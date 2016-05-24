package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESCheckMsg;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESCheckMsgMapper extends Mapper {
    int deleteByPrimaryKey(BigDecimal cmId);

    int insert(ESCheckMsg record);

    int insertSelective(ESCheckMsg record);

    ESCheckMsg selectByPrimaryKey(BigDecimal cmId);

    int updateByPrimaryKeySelective(ESCheckMsg record);

    int updateByPrimaryKey(ESCheckMsg record);
    
    ESCheckMsg selectByBasicId(int basicId);
}