package com.keduw.exception;

import com.keduw.common.R;
import com.keduw.util.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局统一处理异常
 *
 * @author hongshengfeng
 * @date 2020.01.24
 */
@RestControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断是否已定义的错误，不是则由未知错误代替
     * ajax请求的异常返回错误信息，页面请求异常调整到统一处理页面
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionGet(HttpServletRequest request, Exception e){
        if(Request.isAjax(request)){
            logger.error("err", e);
            return R.error("系统错误");
        }
        if(e instanceof DescribeException){
            DescribeException desc = (DescribeException) e;
            return R.info(desc.getCode(), desc.getMessage());
        }else{
            logger.error("err", e);
            return R.error(e.getMessage());
        }
    }
}
