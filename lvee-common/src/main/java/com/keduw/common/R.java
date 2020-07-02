package com.keduw.common;

import com.keduw.exception.Errno;
import com.keduw.exception.Result;

/**
 * 统一数据返回
 *
 * @author hongshengfeng
 * @date 2020.07.02
 * @version 1.0.1
 */
public class R {

    public static Result success(){
        return success(null);
    }

    /**
     * 返回具体数据
     * @param date
     * @return
     */
    public static Result success(Object date){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(Errno.OK);
        result.setMsg("success");
        result.setData(date);
        return result;
    }

    public static Result error(){
        return error(null);
    }

    /**
     * 异常，返回错误提示
     * @param msg
     * @return
     */
    public static Result error(String msg){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(Errno.ERROR);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result info(int code, String msg){
        return info(true, code, msg);
    }


    public static Result info(boolean rt, int code, String msg){
        return info(rt, code, msg, null);
    }

    /**
     * 返回自定义状态信息
     * @return
     */
    public static Result info(boolean rt, int code, String msg, Object date){
        Result info = new Result();
        info.setSuccess(rt);
        info.setCode(code);
        info.setMsg(msg);
        info.setData(date);
        return info;
    }
}
