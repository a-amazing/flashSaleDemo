package com.wangyi.flashsale.entity.resp;

import com.wangyi.flashsale.common.enums.SeckillStatEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
@Slf4j
public class Result extends ResponseEntity {


    public Result(HttpStatus status) {
        super(status);
    }

    public Result(Object body, HttpStatus status) {
        super(body, status);
    }

    public Result(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public Result(Object body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }

    public static Result success() {
        return null;
    }

    public static Result fail(HttpStatus status, SeckillStatEnum seckillStatEnum) {
        return null;
    }
}
