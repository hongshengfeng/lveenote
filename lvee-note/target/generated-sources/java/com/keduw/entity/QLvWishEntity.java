package com.keduw.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLvWishEntity is a Querydsl query type for LvWishEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLvWishEntity extends EntityPathBase<LvWishEntity> {

    private static final long serialVersionUID = 586378288L;

    public static final QLvWishEntity lvWishEntity = new QLvWishEntity("lvWishEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> createTime = createDateTime("createTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> flag = createNumber("flag", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> termId = createNumber("termId", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QLvWishEntity(String variable) {
        super(LvWishEntity.class, forVariable(variable));
    }

    public QLvWishEntity(Path<? extends LvWishEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLvWishEntity(PathMetadata metadata) {
        super(LvWishEntity.class, metadata);
    }

}

