package com.keduw.vortex.exception;

/**
 * 状态码
 *
 * @author 柏渡人
 * @date 2020.01.30
 */
public class Errno {

    public static final int OK = 0;             //查询成功
    public static final int ERROR = -1;         //查询失败
    public static final int NOT_AUTH = 101;     //没有权限
}
