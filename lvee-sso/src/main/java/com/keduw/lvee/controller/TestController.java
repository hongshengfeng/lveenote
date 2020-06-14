package com.keduw.lvee.controller;

import com.keduw.lvee.exception.R;
import com.keduw.lvee.exception.Result;
import com.keduw.lvee.service.TestService;
import com.keduw.lvee.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") int id){
        Test info = testService.getTestInfo(id);
        return R.success(info);
    }

    @RequestMapping("/info2/{id}")
    public Result info2(@PathVariable("id") int id){
        Test info = testService.getTestInfo2(id);
        return R.success(info);
    }
}
