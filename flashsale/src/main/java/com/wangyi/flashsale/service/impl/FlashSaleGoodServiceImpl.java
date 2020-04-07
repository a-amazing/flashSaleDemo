package com.wangyi.flashsale.service.impl;

import com.wangyi.flashsale.common.enums.SeckillStatEnum;
import com.wangyi.flashsale.dao.SeckillMapper;
import com.wangyi.flashsale.dao.SuccessKilledMapper;
import com.wangyi.flashsale.entity.dataobject.Seckill;
import com.wangyi.flashsale.entity.req.SeckillReq;
import com.wangyi.flashsale.entity.resp.Result;
import com.wangyi.flashsale.manager.MQManager;
import com.wangyi.flashsale.service.FlashSaleGoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
@Service
@Slf4j
public class FlashSaleGoodServiceImpl implements FlashSaleGoodService {
    @Autowired
    private SeckillMapper seckillMapper;
    @Autowired
    private SuccessKilledMapper successKilledMapper;
    @Autowired
    private MQManager mqManager;

    @Override
    public List<Seckill> getSeckillList() {
        return seckillMapper.getAllSeckillList();
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillMapper.selectByPrimaryKey(seckillId);
    }

    @Override
    public Integer getSeckillCount(long seckillId) {
        return successKilledMapper.countBySeckillId(seckillId);
    }

    @Override
    @Transactional
    public void deleteSeckill(long seckillId) {
        //1.删除所有已成功的订单
        successKilledMapper.deleteBySeckillId(seckillId);
        //2.将订单数量重置为100
        Seckill seckill = new Seckill();
        seckill.setSeckillId(seckillId).setNumber(100);
        seckillMapper.updateByPrimaryKey(seckill);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result startSeckillDBOcc(SeckillReq secKillReq) {
        int affected = seckillMapper.decreaceByPrimaryKeyWithCount(secKillReq.getSeckillId(), secKillReq.getCount());
        if (affected == 1) {
            mqManager.sendMessage();
            return Result.success();
        }
        return Result.fail(HttpStatus.BAD_REQUEST, SeckillStatEnum.MUCH);
    }

    @Override
    public Result startSeckillByJvmLock(SeckillReq seckillReq) {
        return null;
    }
}
