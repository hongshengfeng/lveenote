package com.keduw.jpa.dao;

import com.keduw.entity.KdNoteEntity;
import com.keduw.jpa.common.CoreDao;

/**
 * @author hongshengfeng
 * @date 2020/07/03
 */
public interface NoteDao extends CoreDao<KdNoteEntity, Integer> {

    KdNoteEntity getById(int id);

}
