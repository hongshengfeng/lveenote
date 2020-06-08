package com.keduw.vortex.controller;

import com.keduw.vortex.exception.Result;
import com.keduw.vortex.util.R;
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
