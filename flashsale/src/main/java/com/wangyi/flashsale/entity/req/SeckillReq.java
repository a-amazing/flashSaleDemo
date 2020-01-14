package com.wangyi.flashsale.entity.req;

import lombok.Data;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
@Data
public class SeckillReq {
    private String userId;
    private Long seckillId;
    private int count;
}
