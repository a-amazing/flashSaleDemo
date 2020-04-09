package com.wangyi.flashsale.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author:wangyi
 * @Date:2020/4/9
 */
@Repository
public class RedisLock {
    @Autowired
    private RedisTemplate<String, String> lockManager;

    /**
     * 使用特定的key和value,指定该锁的有效时间,在不存在该key的情况下加锁
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public boolean lock(String key, String value, long expire) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value) || expire <= 0) {
            return false;
        }
        return lockManager.boundValueOps(key).setIfAbsent(value, expire, TimeUnit.SECONDS);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public boolean unlock(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return false;
        }
        BoundValueOperations<String, String> ops = lockManager.boundValueOps(key);
        String lockValue = ops.get();
        if (!Objects.equals(lockValue, value)) {
            throw new RuntimeException(key + " : " + value + " 对应的redis锁已过期!");
        }
        return lockManager.delete(key);
    }
}
