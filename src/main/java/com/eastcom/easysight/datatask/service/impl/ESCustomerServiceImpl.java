package com.eastcom.easysight.datatask.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import com.eastcom.easysight.datatask.config.MapperFactory;
import com.eastcom.easysight.datatask.service.ESCustomerService;
import com.eastcom.easysight.sql.mapper.ESCustomerMsgMapper;
import com.eastcom.easysight.sql.model.ESCustomerMsg;

@Service
public class ESCustomerServiceImpl implements ESCustomerService{

	@Autowired
	private ESCustomerMsgMapper eSCustomerMsgMapper;//=MapperFactory.ES.createMapper(ESCustomerMsgMapper.class);
	
	@Override
	public void insertBatch(List<ESCustomerMsg> list) {
		eSCustomerMsgMapper.insertBatch(list);
		System.out.println("aaaaaaaaa");
	}

}
