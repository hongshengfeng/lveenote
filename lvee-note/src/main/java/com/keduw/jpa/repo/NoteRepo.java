package com.keduw.jpa.repo;

import com.keduw.entity.KdNoteEntity;
import com.keduw.entity.QKdNoteEntity;
import com.keduw.jpa.common.QuerydslBaseRepo;
import org.springframework.stereotype.Component;

/**
 * @author hongshengfeng
 * @date 2020/07/10
 */

@Component
public class NoteRepo extends QuerydslBaseRepo<KdNoteEntity, QKdNoteEntity> {

    public KdNoteEntity findInfoByUuid(String uuid){
        return queryFactory.select(n).from(n).where(n.uuid.eq(uuid)).fetchOne();
    }

    @Override
    public QKdNoteEntity getEntityPath() {
        return n;
    }

    private QKdNoteEntity n = QKdNoteEntity.kdNoteEntity;
}
