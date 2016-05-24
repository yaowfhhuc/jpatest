package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESPrenodeMsg;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESPrenodeMsgMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal pmId);

    int insert(ESPrenodeMsg record);

    int insertSelective(ESPrenodeMsg record);

    ESPrenodeMsg selectByPrimaryKey(BigDecimal pmId);

    int updateByPrimaryKeySelective(ESPrenodeMsg record);

    int updateByPrimaryKey(ESPrenodeMsg record);
}