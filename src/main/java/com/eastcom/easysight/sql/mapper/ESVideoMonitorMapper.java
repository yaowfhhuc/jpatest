package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESVideoMonitor;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESVideoMonitorMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal vmId);

    int insert(ESVideoMonitor record);

    int insertSelective(ESVideoMonitor record);

    ESVideoMonitor selectByPrimaryKey(BigDecimal vmId);

    int updateByPrimaryKeySelective(ESVideoMonitor record);

    int updateByPrimaryKey(ESVideoMonitor record);
}