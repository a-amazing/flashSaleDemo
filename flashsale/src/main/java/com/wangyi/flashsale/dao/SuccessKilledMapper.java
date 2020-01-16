package com.wangyi.flashsale.dao;

import com.wangyi.flashsale.entity.dataobject.SuccessKilled;
import com.wangyi.flashsale.entity.dataobject.SuccessKilledKey;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessKilledMapper {
    int deleteByPrimaryKey(SuccessKilledKey key);

    int insert(SuccessKilled record);

    int insertSelective(SuccessKilled record);

    SuccessKilled selectByPrimaryKey(SuccessKilledKey key);

    int updateByPrimaryKeySelective(SuccessKilled record);

    int updateByPrimaryKey(SuccessKilled record);

    int countBySeckillId(Long seckillId);

    int deleteBySeckillId(Long seckiiId);
}