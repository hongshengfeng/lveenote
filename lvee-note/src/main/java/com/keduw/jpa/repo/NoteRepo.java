package com.keduw.jpa.repo;

import com.keduw.entity.LvNoteEntity;
import com.keduw.entity.QLvNoteEntity;
import com.keduw.jpa.common.QuerydslBaseRepo;
import com.keduw.jpa.dao.NoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteRepo extends QuerydslBaseRepo<LvNoteEntity, QLvNoteEntity> {

    @Autowired
    private NoteDao noteDao;

    public LvNoteEntity findInfoByUuid(String uuid){
        return queryFactory.select(n).from(n).where(n.uuid.eq(uuid)).fetchOne();
    }

    @Override
    public QLvNoteEntity getEntityPath() {
        return n;
    }

    private QLvNoteEntity n = QLvNoteEntity.lvNoteEntity;
}
