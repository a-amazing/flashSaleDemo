package com.wangyi.flashsale.controller;

import com.wangyi.flashsale.entity.req.SeckillReq;
import com.wangyi.flashsale.entity.resp.Result;
import com.wangyi.flashsale.service.FlashSaleGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
@RestController
public class SeckillController {
    @Autowired
    private FlashSaleGoodService flashSaleGoodService;

    @PostMapping("/seckill1")
    public Result startSeckillDBOcc(@RequestBody @Validated SeckillReq seckillReq){
        return flashSaleGoodService.startSeckillDBOcc(seckillReq);
    }
}
