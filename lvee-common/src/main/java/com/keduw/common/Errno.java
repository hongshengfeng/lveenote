package com.keduw.common;

/**
 * 状态码
 *
 * @author hongshengfeng
 * @date 2020/07/02
 */
public class Errno {

    public static final int OK = 200;               //查询成功
    public static final int ERROR = 500;            //查询失败
    public static final int NOT_FOUND = 404;        //资源不存在

    public static final int ACCESS = 0;             //登录成功
    public static final int TOKEN_EXPIRE = -402;    //登录过期
    public static final int TOKEN_ILLEGAL = -401;   //登录无效

    public static final int NOT_EXIST = 101;        //用户不存在
    public static final int NOT_AUTHORITY = 102;    //权限不足
    public static final int NOT_ACCESS = 103;       //权限验证不通过


}
