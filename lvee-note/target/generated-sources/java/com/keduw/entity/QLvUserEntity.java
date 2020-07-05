package com.keduw.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLvUserEntity is a Querydsl query type for LvUserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLvUserEntity extends EntityPathBase<LvUserEntity> {

    private static final long serialVersionUID = 1740291156L;

    public static final QLvUserEntity lvUserEntity = new QLvUserEntity("lvUserEntity");

    public final NumberPath<Integer> flag = createNumber("flag", Integer.class);

    public final StringPath icon = createString("icon");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath inviteCode = createString("inviteCode");

    public final DateTimePath<java.sql.Timestamp> loginTime = createDateTime("loginTime", java.sql.Timestamp.class);

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final DateTimePath<java.sql.Timestamp> regTime = createDateTime("regTime", java.sql.Timestamp.class);

    public final StringPath tips = createString("tips");

    public final StringPath userName = createString("userName");

    public QLvUserEntity(String variable) {
        super(LvUserEntity.class, forVariable(variable));
    }

    public QLvUserEntity(Path<? extends LvUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLvUserEntity(PathMetadata metadata) {
        super(LvUserEntity.class, metadata);
    }

}

