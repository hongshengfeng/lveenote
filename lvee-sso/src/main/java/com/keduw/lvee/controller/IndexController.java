package com.keduw.lvee.controller;

import com.keduw.lvee.exception.Result;
import com.keduw.lvee.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/info")
    public Result info(HttpServletRequest request){
        return R.success();
    }
}
