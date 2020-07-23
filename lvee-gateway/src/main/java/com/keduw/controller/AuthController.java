package com.keduw.controller;

import com.keduw.common.R;
import com.keduw.util.JsonUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String Login(){

        return JsonUtils.objectToJson(R.ok());
    }
}
