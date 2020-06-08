package com.keduw.vortex.aspect;

import com.keduw.vortex.exception.RRException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Redis切面处理类
 * 通过vortex.redis.open配置判断是否开启Redis操作
 *
 * @author 柏渡人
 * @date 2020.01.23
 */
@Aspect
@Component
public class RedisAspect {

    @Value("${vortex.redis.open:false}")
    private boolean open;
    private static Logger Log = LoggerFactory.getLogger(RedisAspect.class);

    /**
     * redis工具类类环绕通知
     */
    @Around("execution(* com.keduw.vortex.cache.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
            }catch (Exception exp){
                Log.error("redis error", exp);
                throw new RRException("Redis服务异常");
            }
        }
        return result;
    }
}
