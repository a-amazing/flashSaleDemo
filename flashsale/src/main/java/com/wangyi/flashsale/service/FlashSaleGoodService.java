package com.wangyi.flashsale.service;

import com.wangyi.flashsale.entity.dataobject.Seckill;
import com.wangyi.flashsale.entity.req.SeckillReq;
import com.wangyi.flashsale.entity.resp.Result;

import java.util.List;

public interface FlashSaleGoodService {
    /**
     * 查询全部的秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 查询秒杀售卖商品
     * @param seckillId
     * @return
     */
    Integer getSeckillCount(long seckillId);

    /**
     * 删除秒杀售卖商品记录
     * @param seckillId
     * @return
     */
    void deleteSeckill(long seckillId);

    /**
     * 数据库乐观锁实现秒杀
     * @param seckillReq
     * @return
     */
    Result startSeckillDBOcc(SeckillReq seckillReq);

    /**
     * 数据库悲观锁实现秒杀
     * @param seckillReq
     * @return
     */
    Result startSeckillDBXLock(SeckillReq seckillReq);
    /**
     * jvm ReentrantLock实现秒杀
     * @param seckillReq
     * @return
     */
    Result startSeckillByJvmLock(SeckillReq seckillReq);
}
