package com.eastcom.easysight.datatask.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.eastcom.easysight.datatask.service.ESCustomerService;
import com.eastcom.easysight.sql.mapper.ESCustomerMsgMapper;
import com.eastcom.easysight.sql.model.ESCustomerMsg;

@Component
public class UpdateCustomerr {

	private Logger logger = LoggerFactory.getLogger(UpdateCustomer.class);
	
	private ESCustomerService eSCustomerService;
	
	public ESCustomerService geteSCustomerService() {
		return eSCustomerService;
	}

	//@Autowired
	public void seteSCustomerService(ESCustomerService eSCustomerService) {
		this.eSCustomerService = eSCustomerService;
	}

	@Scheduled(cron="0 0 0 * * *")
	public void update(){
		
		List customerList = new ArrayList<ESCustomerMsg>();
		
		eSCustomerService.insertBatch(customerList);
	}
}
