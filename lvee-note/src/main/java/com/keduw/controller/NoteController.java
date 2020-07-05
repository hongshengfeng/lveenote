package com.keduw.controller;

import com.keduw.common.R;
import com.keduw.model.NoteDTO;
import com.keduw.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteController extends BaseController{

    @Autowired
    private NoteService noteService;

    @GetMapping("/info/{uuid}")
    public String info(@PathVariable("uuid") String uuid) throws Exception{
        NoteDTO info = noteService.info(uuid);
        return R.success(info);
    }
}
