package com.keduw.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

/**
 * 实现两个实体类属性之间的复制，属性名大小写不铭感，但要求实体类属性的类型相同
 * 例如：Integer -> int 会转换失败
 *
 * @author hongshengfeng
 * @Date 2020.07.05
 * @Version 1.0.0
 */
public class BeanUtils {

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        if(source == null){
            return null;
        }
        T t = null;
        try {
            t = targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(format("new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        copyProperties(source, t);
        return t;
    }

    private static void copyProperties(Object source, Object target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, null);
    }

    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        return copier;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    private static final Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();
}
