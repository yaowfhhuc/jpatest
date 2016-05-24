package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESOtherDeviceMsg;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESOtherDeviceMsgMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal odId);

    int insert(ESOtherDeviceMsg record);

    int insertSelective(ESOtherDeviceMsg record);

    ESOtherDeviceMsg selectByPrimaryKey(BigDecimal odId);

    int updateByPrimaryKeySelective(ESOtherDeviceMsg record);

    int updateByPrimaryKey(ESOtherDeviceMsg record);
}