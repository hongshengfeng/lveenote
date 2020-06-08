package com.keduw.vortex.exception;

import com.keduw.vortex.util.JsonUtils;
import com.keduw.vortex.util.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局统一处理异常
 *
 * @author 柏渡人
 * @date 2020.01.24
 */
@RestControllerAdvice
public class ExceptionHandle {

    private static final Logger Log = (Logger) LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断是否已定义的错误，不是则由未知错误代替
     * ajax请求的异常返回错误信息，页面请求异常调整到统一处理页面
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionGet(HttpServletRequest request, Exception exp){
        if(Request.isAjax(request)){
            Log.error("error:{}", exp.getMessage());
            return R.error("系统错误");
        }
        if(exp instanceof DescribeException){
            DescribeException e = (DescribeException) exp;
            Result error = R.info(e.getCode(), e.getMessage());
            Log.error("error:{}", JsonUtils.objectToJson(error));
            return error;
        }else{
            Log.error("error:{}", exp.getMessage());
            return R.error(exp.getMessage());
        }
    }
}
