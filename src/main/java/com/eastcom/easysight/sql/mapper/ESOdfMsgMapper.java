package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESOdfMsg;
import com.eastcom.easysight.sql.model.ESOdfMsgKey;

import me.jpa.test.Mapper;

public interface ESOdfMsgMapper extends Mapper{
    int deleteByPrimaryKey(ESOdfMsgKey key);

    int insert(ESOdfMsg record);

    int insertSelective(ESOdfMsg record);

    ESOdfMsg selectByPrimaryKey(ESOdfMsgKey key);

    int updateByPrimaryKeySelective(ESOdfMsg record);

    int updateByPrimaryKey(ESOdfMsg record);
}