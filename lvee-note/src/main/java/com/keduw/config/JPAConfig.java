package com.keduw.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
@Configuration
public class JPAConfig {

    @Bean
    public JPAQueryFactory jpaQuery(EntityManager em) {
        return new JPAQueryFactory(em);
    }
}
