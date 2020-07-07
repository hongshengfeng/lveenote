package com.keduw.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hongshengfeng
 * @version 2020/07/07
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static ApplicationContext getContext(){
		return context;
	}

	public static Object getBean(String name) {
		return getContext().getBean(name);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return getContext().getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return getContext().containsBean(name);
	}

	public static boolean isSingleton(String name) {
		return getContext().isSingleton(name);
	}

	public static Class<? extends Object> getType(String name) {
		return getContext().getType(name);
	}

}