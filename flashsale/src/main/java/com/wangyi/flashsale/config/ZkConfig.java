package com.wangyi.flashsale.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author:wangyi
 * @Date:2020/4/13
 */
@ConfigurationProperties(prefix = "zk")
public class ZkConfig {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
