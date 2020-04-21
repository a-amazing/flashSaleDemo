package com.wangyi.flashsale.common.limiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author:wangyi
 * @Date:2020/4/20
 */
public class RedisLimiter implements Limiter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static int PERIOD = 1;
    private static int MAX_COUNT = 1000;

    @Override
    public boolean pass() {
        String key = String.format("hist:%s:%s", "wangyi", "test");
        long nowTs = System.currentTimeMillis();
        BoundZSetOperations<String, String> zSetOperations = redisTemplate.boundZSetOps(key);
        zSetOperations.add(nowTs+"",nowTs);
        //pipe.multi();
        //pipe.zadd(key, nowTs, "" + nowTs);
        zSetOperations.rangeByScore(0,nowTs - PERIOD * 1000);
        //pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Long count = zSetOperations.zCard();
        if(count == null){
            count = 0L;
        }
        //Response<Long> count = pipe.zcard(key);
        //pipe.expire(key, period + 1);
        //pipe.exec();
        //pipe.close();
        return count <= MAX_COUNT;
    }
}
