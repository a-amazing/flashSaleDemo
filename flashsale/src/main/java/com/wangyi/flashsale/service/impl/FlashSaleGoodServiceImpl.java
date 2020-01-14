package com.wangyi.flashsale.service.impl;

import com.wangyi.flashsale.common.enums.SeckillStatEnum;
import com.wangyi.flashsale.dao.SeckillMapper;
import com.wangyi.flashsale.entity.req.SeckillReq;
import com.wangyi.flashsale.entity.resp.Result;
import com.wangyi.flashsale.manager.MQManager;
import com.wangyi.flashsale.service.FlashSaleGoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private MQManager mqManager;

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
}
