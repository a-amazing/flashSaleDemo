package com.wangyi.flashsale.dao;

import com.wangyi.flashsale.entity.dataobject.Seckill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeckillMapper {
    int deleteByPrimaryKey(Long seckillId);

    int insert(Seckill record);

    int insertSelective(Seckill record);

    Seckill selectByPrimaryKey(Long seckillId);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);

    int decreaceByPrimaryKeyWithCount(@Param("seckillId") Long seckillId, @Param("count") int count);
}