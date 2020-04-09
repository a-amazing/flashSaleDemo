package com.wangyi.flashsale.common.limiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * guava 令牌桶限流
 *
 * @author wangyi
 * @date 2020/04/07
 */
public class GuavaLimiter implements Limiter {
    private static long LIMIT_PER_SECOND = 1000L;
    private static RateLimiter limiter = RateLimiter.create(LIMIT_PER_SECOND);

    @Override
    public boolean pass() {
        //获取失败直接返回false
        return limiter.tryAcquire();
    }
}
