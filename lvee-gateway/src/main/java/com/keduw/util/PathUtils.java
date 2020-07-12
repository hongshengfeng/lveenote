package com.keduw.util;

import org.springframework.util.AntPathMatcher;

/**
 * @author hongshengfeng
 * @date 2020/07/12
 */
public class PathUtils {

    private static AntPathMatcher matcher = new AntPathMatcher();

    public static boolean match(String pattern, String path) {
        return matcher.match(pattern, path);
    }
}
