package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESGprsMsg;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESGprsMsgMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal gsId);

    int insert(ESGprsMsg record);

    int insertSelective(ESGprsMsg record);

    ESGprsMsg selectByPrimaryKey(BigDecimal gsId);

    int updateByPrimaryKeySelective(ESGprsMsg record);

    int updateByPrimaryKey(ESGprsMsg record);
}