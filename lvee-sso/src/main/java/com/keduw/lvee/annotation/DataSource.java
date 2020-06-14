package com.keduw.lvee.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author 柏渡人
 * @date 2020.02.04
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String name() default "";
}
