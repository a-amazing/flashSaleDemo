package com.wangyi.flashsale.common.limiter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author:wangyi
 * @Date:2019/11/25
 */
public class CountLimiter implements Limiter {
    private AtomicLong count = new AtomicLong(0);
    //private LongAdder count = new LongAdder();
    //如果要使用LongAdder实现,要怎么处理
    private int limitNum = 100;
    private int timeMillium = 1000;

    @Override
    public boolean pass() {
        long increment = count.getAndIncrement();
        if (increment > limitNum) {
            return false;
        }
        return true;
    }

    public void init() throws InterruptedException {
        while (true) {
            Thread.sleep(timeMillium);
            count.set(0);
        }
    }
}
