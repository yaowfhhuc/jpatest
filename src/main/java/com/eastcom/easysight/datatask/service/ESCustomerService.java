package com.eastcom.easysight.datatask.service;

import java.util.List;

import com.eastcom.easysight.sql.model.ESCustomerMsg;

public interface ESCustomerService {

	public static String SERVIVE_NAME="ESCustomerService";
	
	public void insertBatch(List<ESCustomerMsg> list);
	
}
