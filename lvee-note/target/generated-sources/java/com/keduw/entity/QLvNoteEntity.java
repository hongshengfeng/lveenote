package com.keduw.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLvNoteEntity is a Querydsl query type for LvNoteEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLvNoteEntity extends EntityPathBase<LvNoteEntity> {

    private static final long serialVersionUID = -819493061L;

    public static final QLvNoteEntity lvNoteEntity = new QLvNoteEntity("lvNoteEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> createTime = createDateTime("createTime", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> endTime = createDateTime("endTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> flag = createNumber("flag", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> termId = createNumber("termId", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public final StringPath uuid = createString("uuid");

    public QLvNoteEntity(String variable) {
        super(LvNoteEntity.class, forVariable(variable));
    }

    public QLvNoteEntity(Path<? extends LvNoteEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLvNoteEntity(PathMetadata metadata) {
        super(LvNoteEntity.class, metadata);
    }

}

