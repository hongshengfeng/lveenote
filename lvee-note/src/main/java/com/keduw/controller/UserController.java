package com.keduw.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户数据处理
 *
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{

    @PostMapping("/info")
    public String info(){
        return "测试成功";
    }
}
