package com.keduw.vortex.exception;

/**
 * 自定义错误信息
 *
 * @author 柏渡人
 * @date 2020.01.24
 */
public class DescribeException extends RuntimeException{

    private int code;

    public DescribeException(Result result){
        super(result.getMsg());
        this.code = result.getCode();
    }

    public DescribeException(String message, int code){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
