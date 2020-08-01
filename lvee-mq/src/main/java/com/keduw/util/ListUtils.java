/*
 * Copyright (c) 2010 by XUANWU INFORMATION TECHNOLOGY CO.
 *             All rights reserved
 */
package com.keduw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author <a href="hw86xll@163.com">Wei.Huang</a>
 * @Date 2011-7-13
 * @Version 1.0.0
 */
public class ListUtils {

    //-----------------------------------------------------------------------

    /**
     * Null-safe check if the specified collection is empty.
     * <p>
     * Null returns true.
     *
     * @param list the collection to check, may be null
     * @return true if empty or null
     */
    public static <T> boolean isBlank(List<T> list) {
        return (list == null || list.isEmpty());
    }

    /**
     * Null-safe check if the specified collection is not empty.
     * <p>
     * Null returns false.
     *
     * @param list the collection to check, may be null
     * @return true if non-null and non-empty
     */
    public static <T> boolean isNotBlank(List<T> list) {
        return !ListUtils.isBlank(list);
    }

    public static <T> List<T> cloneList(List<T> list) {
        List<T> temp = new ArrayList<T>();

        if (list == null)
            return temp;

        temp.addAll(list);

        return temp;
    }

    public static <T> void clearList(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> List<List<T>> splitList(List<T> list, int maxSize) {

        List<List<T>> temp = new ArrayList<List<T>>();
        if (list.size() == 0 || maxSize <= 0) {
            return temp;
        }

        int i = 0;
        while (i < list.size()) {
            int toIndex = (i + maxSize);
            if (toIndex > list.size()) {
                toIndex = toIndex - maxSize + (list.size() - i);
            }
            temp.add(new ArrayList<T>(list.subList(i, toIndex)));
            i += maxSize;
        }
        return temp;

    }

    public static <T> void extractQueueItems(int extractSize,
                                             T headItem, List<T> extractList, BlockingQueue<T> queue) {
        if (headItem != null)
            extractList.add(headItem);

        for (; ; ) {
            if (extractList.size() >= extractSize || queue.isEmpty())
                break;

            T item = queue.poll();
            if (item != null)
                extractList.add(item);
        }
    }

    public static List extractField(List list, String fieldName) {
        try {
            if (list == null || list.size() == 0) {
                return new ArrayList(0);
            }
            List<Object> target = new ArrayList<>();
            Method declaredMethod = list.get(0).getClass().getDeclaredMethod("get" + upperFirstLetterCase(fieldName));
            for (Object o : list) {
                Object invoke = declaredMethod.invoke(o);
                if(invoke!=null) {
                    target.add(invoke);
                }
            }
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String upperFirstLetterCase(String str) {
        if (str.length() > 0) {
            char[] ch = str.toCharArray();
            if (ch[0] >= 'a' && ch[0] <= 'z') {
                ch[0] = (char) (ch[0] - 32);
            }
            return new String(ch);
        }
        return "";
    }

    public static <T, Y> List<T> transferEntity(List<Y> list, Class<T> target) {
        try {
            List<T> result = new ArrayList<>();
            if (list != null && list.size() > 0) {
                Class<?> origin = list.get(0).getClass();
                Constructor<T> constructor = target.getConstructor(origin);
                for (Y y : list) {
                    result.add(constructor.newInstance(y));
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
