package com.wangyi.flashsale.entity.resp;

import com.wangyi.flashsale.common.enums.SeckillStatEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
public class Result extends ResponseEntity {

    private static Map<String, String> successMap = new HashMap<>();

    static {
        successMap.put("retCode", "0");
        successMap.put("retMsg", "success");
    }

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
        return new Result(successMap, HttpStatus.OK);
    }

    public static Result fail(SeckillStatEnum seckillStatEnum) {
        Map<String, String> retMap = new HashMap<>();
        retMap.put("retCode", String.valueOf(seckillStatEnum.getState()));
        retMap.put("retMsg", seckillStatEnum.getInfo());
        return new Result(retMap, HttpStatus.TOO_MANY_REQUESTS);
    }
}
