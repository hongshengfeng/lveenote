package com.keduw.exception;

import com.keduw.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;


/**
 * 统一异常处理
 *
 * @author hongshengfeng
 * @date 2020.01.24
 */
@RestControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e){
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());
        return r;
    }

    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){
        logger.error(e.getMessage(), e);
        return R.error();
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

}
