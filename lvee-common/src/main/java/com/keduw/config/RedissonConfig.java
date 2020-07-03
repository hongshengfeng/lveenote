package com.keduw.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;

@Configuration
@ConditionalOnProperty(prefix = "lvee", name = "redis", havingValue = "true")
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws Exception{
        try {
            ClassPathResource resource = new ClassPathResource("redisson.json");
            if (resource.getFile().exists()) {
                return Redisson.create(Config.fromJSON(resource.getInputStream()));
            }
        } catch (FileNotFoundException e) {
            ClassPathResource resource = new ClassPathResource("redisson-sentinel.json");
            if (resource.getFile().exists()) {
                return Redisson.create(Config.fromJSON(resource.getInputStream()));
            }
        }
        return null;
    }
}
