package com.wangyi.flashsale.dao;

import com.wangyi.flashsale.entity.dataobject.FlashSaleGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author:wangyi
 * @Date:2020/4/9
 */
public class GoodRedisDao {

    @Autowired
    private RedisTemplate<String, FlashSaleGood> redisTemplate;


}
