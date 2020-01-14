package com.wangyi.flashsale.service;

import com.wangyi.flashsale.entity.req.SeckillReq;
import com.wangyi.flashsale.entity.resp.Result;

public interface FlashSaleGoodService {
    /**
     * 数据库乐观锁实现秒杀
     * @param seckillReq
     * @return
     */
    Result startSeckillDBOcc(SeckillReq seckillReq);
}
