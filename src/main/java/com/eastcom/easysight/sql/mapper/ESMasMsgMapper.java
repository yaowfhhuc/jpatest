package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESMasMsg;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESMasMsgMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal mmId);

    int insert(ESMasMsg record);

    int insertSelective(ESMasMsg record);

    ESMasMsg selectByPrimaryKey(BigDecimal mmId);

    int updateByPrimaryKeySelective(ESMasMsg record);

    int updateByPrimaryKey(ESMasMsg record);
}