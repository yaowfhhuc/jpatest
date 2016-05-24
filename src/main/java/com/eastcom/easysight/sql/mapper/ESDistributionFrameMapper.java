package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESDistributionFrame;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESDistributionFrameMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal dfId);

    int insert(ESDistributionFrame record);

    int insertSelective(ESDistributionFrame record);

    ESDistributionFrame selectByPrimaryKey(BigDecimal dfId);

    int updateByPrimaryKeySelective(ESDistributionFrame record);

    int updateByPrimaryKey(ESDistributionFrame record);
}