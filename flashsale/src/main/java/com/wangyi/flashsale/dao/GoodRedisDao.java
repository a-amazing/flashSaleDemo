package com.wangyi.flashsale.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author:wangyi
 * @Date:2020/4/9
 */
public class GoodRedisDao {

    /**
     * 在纯java栈的情况下,可以使用redisTemplate
     */
    @Autowired
    private StringRedisTemplate redisTemplate;


}
