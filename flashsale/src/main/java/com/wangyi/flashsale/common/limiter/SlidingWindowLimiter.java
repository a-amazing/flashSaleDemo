package com.wangyi.flashsale.common.limiter;

import java.util.LinkedList;
import java.util.concurrent.atomic.LongAdder;

/**
 * 滑动窗口限流实现
 *
 * @author:wangyi
 * @Date:2019/11/25
 */
public class SlidingWindowLimiter implements Limiter {

    private LongAdder count = new LongAdder();
    LinkedList<Long> longList = new LinkedList<>();
    private int timeMillions;
    private int limitCount;

    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    longList.add(count.longValue());
                    if (longList.size() > 10) {
                        longList.removeFirst();
                    }
                    try {
                        Thread.sleep(timeMillions);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public SlidingWindowLimiter(int timeMillions, int limitCount) {
        this.timeMillions = timeMillions;
        this.limitCount = limitCount;
    }

    @Override
    public boolean pass() {
        count.add(1L);
        if (count.longValue() - longList.peekFirst() > limitCount) {
            return false;
        }
        return true;
    }
}
