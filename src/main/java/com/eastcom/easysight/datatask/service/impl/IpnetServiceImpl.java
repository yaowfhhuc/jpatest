package com.eastcom.easysight.datatask.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eastcom.easysight.datatask.config.MapperFactory;
import com.eastcom.easysight.datatask.service.IpnetService;
import com.eastcom.easysight.sql.mapper.ESCheckMsgMapper;
import com.eastcom.easysight.sql.model.ESCheckMsg;
import com.eastcom.easysight.sql.model.ESCustomerMsg;


public class IpnetServiceImpl implements IpnetService {

	@Autowired
	private ESCheckMsgMapper checkMsgMapper; //= MapperFactory.ES.createMapper(ESCheckMsgMapper.class);
	
/*	@Autowired
	private ESCustomerMsgMapper customerMsgMapper;
	*/
	public ESCheckMsg getByBasicId(String id){
		return null;//checkMsgMapper.selectByBasicId(Integer.parseInt(id));
	}

	@Override
	public void setBasicMsgBatch(List<ESCustomerMsg> list) {
		//customerMsgMapper.insertBatch(list);
	}
	
}
