package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESDistributionAtom;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESDistributionAtomMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal daId);

    int insert(ESDistributionAtom record);

    int insertSelective(ESDistributionAtom record);

    ESDistributionAtom selectByPrimaryKey(BigDecimal daId);

    int updateByPrimaryKeySelective(ESDistributionAtom record);

    int updateByPrimaryKey(ESDistributionAtom record);
}