package com.keduw.lvee.aop;

import com.keduw.lvee.annotation.DataSource;
import com.keduw.lvee.datasources.DataSourceDef;
import com.keduw.lvee.datasources.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理，通过 @DataSource注解指定数据源
 *
 * @author 柏渡人
 * @date 2020.02.04
 */
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.keduw.lvee.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            //默认数据源
            DynamicDataSource.setDataSource(DataSourceDef.FIRST);
        }else {
            //使用注解指定的数据源
            DynamicDataSource.setDataSource(ds.name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }
}
