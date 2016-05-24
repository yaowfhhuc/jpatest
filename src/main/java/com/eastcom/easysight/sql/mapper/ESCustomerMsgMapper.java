package com.eastcom.easysight.sql.mapper;

import com.eastcom.easysight.sql.model.ESCustomerMsg;

import me.jpa.test.Mapper;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.sql.DataSourceDefinitions;
public interface ESCustomerMsgMapper extends Mapper{
    int deleteByPrimaryKey(BigDecimal basicId);

    int insert(ESCustomerMsg record);
    
    int insertBatch(List<ESCustomerMsg> record);

    int insertSelective(ESCustomerMsg record);

    ESCustomerMsg selectByPrimaryKey(BigDecimal basicId);

    int updateByPrimaryKeySelective(ESCustomerMsg record);

    int updateByPrimaryKey(ESCustomerMsg record);
}