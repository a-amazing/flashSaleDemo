package com.wangyi.flashsale.util.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author:wangyi
 * @Date:2020/4/13
 */
public class ZkLock {

    public static CuratorFramework client;

    static{
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
        client.start();
    }
}
