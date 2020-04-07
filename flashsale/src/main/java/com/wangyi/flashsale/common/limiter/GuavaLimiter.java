package com.wangyi.flashsale.common.limiter;

/**
 * guava 令牌桶限流
 * @author wangyi
 * @date 2020/04/07
 */
public class GuavaLimiter implements Limiter {
    @Override
    public boolean pass() {
        return false;
    }
}
