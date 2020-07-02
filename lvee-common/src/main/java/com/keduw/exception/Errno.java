package com.keduw.exception;

/**
 * 状态码
 *
 * @author hongshengfeng
 * @date 2020.07.02
 * @version 1.0
 */
public class Errno {

    public static final int OK = 0;             //查询成功
    public static final int ERROR = -1;         //查询失败
    public static final int NOT_FOUND = 101;    //用户不存在
}
