package com.keduw.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;



/**
 * 验证码配置
 *
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
@Configuration
@ConditionalOnProperty(prefix = "lvee", name = "kaptcha", havingValue = "true")
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "5");
        properties.put("kaptcha.textproducer.font.names", "Arial,Courier,cmr10,宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
