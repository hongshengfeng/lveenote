package com.keduw.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author hongshengfeng
 * @date 2020/07/03
 */
@Configuration
public class QueryDslConfig {

    @Autowired
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory getQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
