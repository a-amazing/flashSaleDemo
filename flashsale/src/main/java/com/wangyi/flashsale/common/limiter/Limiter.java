package com.wangyi.flashsale.common.limiter;

public interface Limiter {
    /**
     * 获取资格,返回true进入系统处理,返回false直接抛弃(响应网络问题等...)
     * @return
     */
    public boolean pass();
}
