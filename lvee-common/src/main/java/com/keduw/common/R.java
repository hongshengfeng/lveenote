package com.keduw.common;

import com.keduw.exception.Errno;
import com.keduw.exception.Result;
import com.keduw.util.JsonUtils;

/**
 * 统一数据返回
 *
 * @author hongshengfeng
 * @date 2020.07.02
 * @version 1.0.1
 */
public class R {

    public static String success(){
        return success(null);
    }

    /**
     * 返回具体数据
     * @param date
     * @return
     */
    public static String success(Object date){
        Result info = new Result();
        info.setSuccess(true);
        info.setCode(Errno.OK);
        info.setMsg("success");
        info.setData(date);
        return JsonUtils.objectToJson(info);
    }

    public static String error(){
        return error(null);
    }

    /**
     * 异常，返回错误提示
     * @param msg
     * @return
     */
    public static String error(String msg){
        Result info = new Result();
        info.setSuccess(false);
        info.setCode(Errno.ERROR);
        info.setMsg(msg);
        info.setData(null);
        return JsonUtils.objectToJson(info);
    }

    public static String info(int code, String msg){
        return info(true, code, msg);
    }


    public static String info(boolean rt, int code, String msg){
        return info(rt, code, msg, null);
    }

    /**
     * 返回自定义状态信息
     * @return
     */
    public static String info(boolean rt, int code, String msg, Object date){
        Result info = new Result();
        info.setSuccess(rt);
        info.setCode(code);
        info.setMsg(msg);
        info.setData(date);
        return JsonUtils.objectToJson(info);
    }
}
