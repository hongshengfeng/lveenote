package com.keduw.app;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义不需要被过滤的URI
 *
 * @author hongshengfeng
 * @date 2020/07/12
 */
@Component
public class URIFilterDef {

    private static final List<String> R_URI = new ArrayList<>();

    @PostConstruct
    public void init(){
        R_URI.add("/api/login/**");
        R_URI.add("/api/resource/**");
    }

    public List<String> initURI(){
        return R_URI;
    }
}
