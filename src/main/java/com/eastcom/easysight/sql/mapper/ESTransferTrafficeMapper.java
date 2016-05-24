package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESTransferTraffice;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESTransferTrafficeMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal ttId);

    int insert(ESTransferTraffice record);

    int insertSelective(ESTransferTraffice record);

    ESTransferTraffice selectByPrimaryKey(BigDecimal ttId);

    int updateByPrimaryKeySelective(ESTransferTraffice record);

    int updateByPrimaryKey(ESTransferTraffice record);
}