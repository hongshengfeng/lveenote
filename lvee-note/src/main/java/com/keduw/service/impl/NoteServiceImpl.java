package com.keduw.service.impl;

import com.keduw.entity.LvNoteEntity;
import com.keduw.jpa.repo.NoteRepo;
import com.keduw.model.NoteDTO;
import com.keduw.service.NoteService;
import com.keduw.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongshengfeng
 * @date 2020/07/07
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService {

    private static final Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepo noteRepo;

    @Override
    public NoteDTO info(String uuid){
        try {
            LvNoteEntity info = noteRepo.findInfoByUuid(uuid);
            return BeanUtils.copyProperties(info, NoteDTO.class);
        }catch (Exception e){
            logger.error("getInfo err", e);
        }
        return null;
    }
}
