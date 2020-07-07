package com.keduw.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author hongshengfeng
 * @date 2020/07/07
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";

}
