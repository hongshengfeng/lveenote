package com.keduw.service.impl;

import com.keduw.entity.LvNoteEntity;
import com.keduw.jpa.repo.NoteRepo;
import com.keduw.model.NoteDTO;
import com.keduw.service.NoteService;
import com.keduw.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Override
    public NoteDTO info(String uuid) throws Exception {
        LvNoteEntity info = noteRepo.findInfoByUuid(uuid);
        return BeanUtils.copyProperties(info, NoteDTO.class);
    }
}
