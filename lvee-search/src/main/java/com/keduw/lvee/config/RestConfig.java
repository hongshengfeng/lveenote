package com.keduw.lvee.config;

import com.keduw.lvee.app.AuthDef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        String auth = AuthDef.initInfo();
        byte[] encode = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encode);
        headers.set("Authorization", authHeader);
        return headers;
    }
}
