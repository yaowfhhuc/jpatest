package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESDataTraffic;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESDataTrafficMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal dtId);

    int insert(ESDataTraffic record);

    int insertSelective(ESDataTraffic record);

    ESDataTraffic selectByPrimaryKey(BigDecimal dtId);

    int updateByPrimaryKeySelective(ESDataTraffic record);

    int updateByPrimaryKey(ESDataTraffic record);
}