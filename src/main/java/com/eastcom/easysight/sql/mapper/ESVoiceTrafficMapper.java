package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESVoiceTraffic;

import me.jpa.test.Mapper;

import java.math.BigDecimal;

public interface ESVoiceTrafficMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal vtId);

    int insert(ESVoiceTraffic record);

    int insertSelective(ESVoiceTraffic record);

    ESVoiceTraffic selectByPrimaryKey(BigDecimal vtId);

    int updateByPrimaryKeySelective(ESVoiceTraffic record);

    int updateByPrimaryKey(ESVoiceTraffic record);
}