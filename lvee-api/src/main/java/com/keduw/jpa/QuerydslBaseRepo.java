package com.keduw.jpa;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.hibernate.tuple.entity.EntityBasedBasicAttribute;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;

public abstract class QuerydslBaseRepo<T, Q extends EntityPath<T>> {

    @Autowired
    public JPAQueryFactory queryFactory;

    @Autowired
    public EntityManager entityManager;

    public abstract Q getEntityPath();

    /**
     * 获取更新语句，根据实体中属性是否有值进行更新
     * @param entity
     * @param conditions
     * @return
     */
    public JPAUpdateClause getUpdateClause(T entity, Predicate[] conditions) {
        return getUpdateClause(entity, conditions, false);
    }

    /**
     * 获取更新所有列的语句
     * @param entity
     * @param conditions
     * @return
     */
    public JPAUpdateClause getAllUpdateClause(T entity, Predicate[] conditions) {
        return getUpdateClause(entity, conditions, true);
    }

    /**
     * 获取更新语句，
     * @param entity 更新实体
     * @param conditions 更新语句的where条件
     * @param updateAllColumn 是否更新所有列（true更新所有列，false只更新非空列）
     * @return
     */
    private JPAUpdateClause getUpdateClause(T entity, Predicate[] conditions, boolean updateAllColumn) {
        if(entity == null || conditions == null){
            throw new RuntimeException("更新数据不能为空");
        }
        try {
            EntityPath<T> entityPath = getEntityPath();
            JPAUpdateClause clause = queryFactory.update(entityPath);
            MetamodelImplementor model = (MetamodelImplementor) entityManager.getMetamodel();
            EntityPersister entityPersister = model.entityPersister(entity.getClass());
            for (AttributeDefinition attr : entityPersister.getAttributes()) {
                // 判断是否是数据库字段属性
                if (!(attr instanceof EntityBasedBasicAttribute)) {
                    continue;
                }
                // 获取querydsl对象的属性
                String proName = attr.getName();
                Field entityPathField = entityPath.getClass().getDeclaredField(proName);
                if (!Path.class.isAssignableFrom(entityPathField.getType())) {
                    continue;
                }
                // 获取值对象属性值
                Field entityField = entity.getClass().getDeclaredField(proName);
                entityField.setAccessible(true);
                Object v = entityField.get(entity);
                // 设置update语句的set子句
                if (v != null) {
                    entityPathField.setAccessible(true);
                    clause.set((Path) entityPathField.get(entityPath), v);
                } else if (updateAllColumn) {
                    clause.setNull((Path) entityPathField.get(entityPath));
                }
            }
            // 设置update语句的where子句
            return clause.where(conditions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 位运算and
     * @param arg1
     * @param arg2
     * @return
     */
    public static NumberTemplate<Integer> bitAnd(Object arg1, Object arg2) {
        return Expressions.numberTemplate(Integer.class, "function('bitand', {0}, {1})", arg1, arg2);
    }

    /**
     * 位运算or
     * @param arg1
     * @param arg2
     * @return
     */
    public static NumberTemplate<Integer> bitOr(Object arg1, Object arg2) {
        return Expressions.numberTemplate(Integer.class, "function('bitor', {0}, {1})", arg1, arg2);
    }

    /**
     * 位运算xor
     * @param arg2
     * @param arg1
     * @return
     */
    public static NumberTemplate<Integer> bitXor(Object arg1, Object arg2) {
        return Expressions.numberTemplate(Integer.class, "function('bitxor', {0}, {1})", arg1, arg2);
    }

}
