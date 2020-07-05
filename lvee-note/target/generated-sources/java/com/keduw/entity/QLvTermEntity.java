package com.keduw.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLvTermEntity is a Querydsl query type for LvTermEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLvTermEntity extends EntityPathBase<LvTermEntity> {

    private static final long serialVersionUID = -1784457163L;

    public static final QLvTermEntity lvTermEntity = new QLvTermEntity("lvTermEntity");

    public final DateTimePath<java.sql.Timestamp> createTime = createDateTime("createTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> flag = createNumber("flag", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> odds = createNumber("odds", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public final StringPath uuid = createString("uuid");

    public QLvTermEntity(String variable) {
        super(LvTermEntity.class, forVariable(variable));
    }

    public QLvTermEntity(Path<? extends LvTermEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLvTermEntity(PathMetadata metadata) {
        super(LvTermEntity.class, metadata);
    }

}

