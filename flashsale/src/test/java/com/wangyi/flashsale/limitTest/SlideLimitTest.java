package com.wangyi.flashsale.limitTest;

import com.wangyi.flashsale.common.limiter.SlidingWindowLimiter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangyi
 * @date 2019/12/01
 */
public class SlideLimitTest {

    @Test
    public void test1(){
        CountDownLatch test = new CountDownLatch(10000);
        SlidingWindowLimiter limiter = new SlidingWindowLimiter(100, 100);
        AtomicInteger atomicInt = new AtomicInteger(0);


        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(limiter.pass()){
                        atomicInt.getAndAdd(1);
                        System.out.println("未被限流!");
                    }
                    test.countDown();
                }
            }).start();
        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(atomicInt.get());
    }
}
