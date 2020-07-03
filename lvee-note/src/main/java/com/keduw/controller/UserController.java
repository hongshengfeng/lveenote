package com.keduw.controller;

import com.keduw.common.R;
import com.keduw.model.User;
import com.keduw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public String info(){
        int id = 1;
        User info = userService.getInfo(id);
        return R.success(info);
    }

    @GetMapping("/info2")
    public String info2(){
        int id = 1;
        User info = userService.getInfoByDsl(1);
        return R.success(info);
    }
}
