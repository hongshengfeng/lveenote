package com.keduw.controller;

import com.keduw.common.R;
import com.keduw.model.NoteDTO;
import com.keduw.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongshengfeng
 * @date 2020/07/06
 */
@RestController
@RequestMapping("/note")
public class NoteController extends BaseController{

    @Autowired
    private NoteService noteService;

    @GetMapping("/info/{uuid}")
    public R info(@PathVariable("uuid") String uuid) throws Exception{
        NoteDTO note = noteService.info(uuid);
        Map<String, Object> info = new HashMap<>();
        info.put("data", note);
        return R.ok(info);
    }
}
