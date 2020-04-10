package com.wangyi.flashsale.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @author:wangyi
 * @Date:2020/1/16
 * @Description:redis交互管理类
 */
@Slf4j
public class RedisManager {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置对象
     *
     * @param key   key
     * @param value value值
     * @param <T>   返回值泛型
     * @return 正确的值：<T> 错误的值：null
     */
    @SuppressWarnings("unchecked")
    public <T> ValueOperations<String, T> setObject(final String key, final T value) {
        final ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
        return operation;
    }

    /**
     * 设置对象及失效时间 (单位：秒)
     *
     * @param key   key
     * @param value value值
     * @param <T>   返回值泛型
     * @param time  秒值
     * @return 正确的值：<T> 错误的值：null
     */
    @SuppressWarnings("unchecked")
    public <T> ValueOperations<String, T> setObject(final String key, final T value, final long time) {
        final ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, time, TimeUnit.SECONDS);
        return operation;
    }


    /**
     * 设置对象及失效时间（单位：毫秒）
     *
     * @param key   key
     * @param value value值
     * @param <T>   返回值泛型
     * @param time  秒值
     * @return 正确的值：<T> 错误的值：null
     */
    @SuppressWarnings("unchecked")
    public <T> ValueOperations<String, T> setObjectForMillSeconds(final String key, final T value, final long time) {
        final ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, time, TimeUnit.MILLISECONDS);
        return operation;
    }

    /**
     * 获取对象
     *
     * @param key 键
     * @return 正确的值：Object值对象<br>
     * 错误的值：null
     */
    @SuppressWarnings("unchecked")
    public Object getObject(final String key) {
        final ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        if (valueOperations == null || !redisTemplate.hasKey(key)) {
            return null;
        }
        return valueOperations.get(key);
    }

    /**
     * 从缓存中获取string值
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getString(final String key) {
        String value = "";
        final ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        if (valueOperations != null && redisTemplate.hasKey(key)) {
            final Object object = valueOperations.get(key);
            if (null != object) {
                log.info("--getString--object not empty");
                value = object.toString();
            } else {
                log.info("--getString--object empty");
            }
        }
        return value;
    }
}
