package com.wangyi.flashsale.entity.dataobject;

import java.io.Serializable;

public class SuccessKilledKey implements Serializable {
    private Long seckillId;
    private Long userId;
    public Long getSeckillId() {
        return seckillId;
    }
    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}