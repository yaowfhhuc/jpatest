package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESTypeFuncPort;

import me.jpa.test.Mapper;

public interface ESTypeFuncPortMapper extends Mapper {
    int insert(ESTypeFuncPort record);

    int insertSelective(ESTypeFuncPort record);
}