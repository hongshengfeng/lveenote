package com.keduw.vortex.exception;

/**
 * 统一数据返回
 *
 * @author 柏渡人
 * @date 2020.01.30
 */
public class R {

    /**
     * 成功
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 成功，返回具体参数
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(Errno.OK);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * 错误
     */
    public static Result error(){
        return error(null);
    }

    /**
     * 错误，返回自定义状态码和信息
     */
    public static Result error(String msg){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(Errno.ERROR);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回自定义状态信息
     */
    public static Result info(Integer code, String msg){
        return info(true, code, msg);
    }

    /**
     * 返回自定义状态信息
     */
    public static Result info(boolean sucess, Integer code, String msg){
        Result result = new Result();
        result.setSuccess(sucess);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
