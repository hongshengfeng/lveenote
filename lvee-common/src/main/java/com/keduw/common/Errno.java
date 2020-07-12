package com.keduw.common;

/**
 * 状态码
 *
 * @author hongshengfeng
 * @date 2020/07/02
 */
public class Errno {

    public static final int OK = 0;                 //查询成功
    public static final int ERROR = 500;            //查询失败
    public static final int NOT_FOUND = 404;        //资源不存在

    public static final int NOT_EXIST = 101;        //用户不存在
    public static final int NOT_AUTHORITY = 102;    //权限不足
    public static final int NOT_ACCESS = 103;       //权限验证不通过


}
