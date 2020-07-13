package com.keduw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author hongshengfeng
 * @date 2020/07/07
 */
@EnableZuulProxy
@SpringBootApplication
@EnableTransactionManagement
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
