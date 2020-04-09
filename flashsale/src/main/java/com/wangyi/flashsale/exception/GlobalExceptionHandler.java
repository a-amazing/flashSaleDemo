package com.wangyi.flashsale.exception;

import com.wangyi.flashsale.common.enums.SeckillStatEnum;
import com.wangyi.flashsale.entity.resp.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException ex) {
        return Result.fail(SeckillStatEnum.END);
    }
}
