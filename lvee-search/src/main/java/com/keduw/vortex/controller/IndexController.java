package com.keduw.vortex.controller;

import com.keduw.vortex.exception.R;
import com.keduw.vortex.exception.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;

    @RequestMapping("/search/{id}")
    public Result search(@PathVariable("id") int id) throws Exception{
        String url = TEST_URL + id;
        Result info = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Result.class).getBody();
        return info;
    }

    private static final String TEST_URL = "http://localhost:8080/test/info/";
}
