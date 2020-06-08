package com.keduw.vortex.exception;

/**
 * 统计数据返回的格式
 *
 * @author hsfeng
 */
public class Result<T> {

    private int code;        //状态值
    private String msg;      //错误信息
    private T data;          //返回的内容
    private boolean success; //是否成功

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
