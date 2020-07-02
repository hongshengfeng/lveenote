package com.keduw.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 外部获取bean对象
 *
 * @author hongshengfeng
 * @date 2020.01.23
 * @version 1.0
 */
@Component
public class ContextUtils implements ApplicationContextAware{

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(ContextUtils.context == null){
            ContextUtils.context  = applicationContext;
        }
    }

    /**
     * 通过对象名获取对象
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return context.getBean(name);
    }

}