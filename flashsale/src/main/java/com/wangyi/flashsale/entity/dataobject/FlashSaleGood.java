package com.wangyi.flashsale.entity.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author:wangyi
 * @Date:2020/1/14
 */
@Data
@Accessors(chain = true)
public class FlashSaleGood implements Serializable {
    private long seckillId;
    private String name;
    private int number;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createTime;
    private int version;
}
