package com.keduw.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLvTermMemberEntity is a Querydsl query type for LvTermMemberEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLvTermMemberEntity extends EntityPathBase<LvTermMemberEntity> {

    private static final long serialVersionUID = -527241745L;

    public static final QLvTermMemberEntity lvTermMemberEntity = new QLvTermMemberEntity("lvTermMemberEntity");

    public final NumberPath<Integer> flag = createNumber("flag", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.sql.Timestamp> joinTime = createDateTime("joinTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> termId = createNumber("termId", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QLvTermMemberEntity(String variable) {
        super(LvTermMemberEntity.class, forVariable(variable));
    }

    public QLvTermMemberEntity(Path<? extends LvTermMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLvTermMemberEntity(PathMetadata metadata) {
        super(LvTermMemberEntity.class, metadata);
    }

}

