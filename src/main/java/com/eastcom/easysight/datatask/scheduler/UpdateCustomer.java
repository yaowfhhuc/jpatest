package com.eastcom.easysight.datatask.scheduler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import com.eastcom.easysight.datatask.service.ZiguanService;
import com.eastcom.easysight.sql.model.ESCustomerMsg;

@Component
public class UpdateCustomer implements Runnable{

	private Logger logger = LoggerFactory.getLogger(UpdateCustomer.class);
	
//	private DataSource zgDataSource;
//
//	private DataSource esDataSource;

	private JdbcTemplate zgJdbcTemplate;

	private JdbcTemplate esJdbcTemplate;
	
/*	@Scheduled(cron="0 0 0 * * *")
	public void updateCustomer(){
		
		
	}*/

	public void init(@Qualifier("esDataSource") DataSource esDataSource,@Qualifier("zgDataSource") DataSource zgDataSource){
		System.out.println(esDataSource.toString());
		System.out.println(zgDataSource.toString());
		zgJdbcTemplate = new JdbcTemplate(zgDataSource);
		esJdbcTemplate = new JdbcTemplate(esDataSource);
		
	}
	
	@Override
	public void run() {
		MDC.put("task-name", "updateCustomer");
		logger.info("##updateCustomer task running...##");
		
		String sql = "select * from C_NE_GROUPCUSTOMER ";
		
		final List<ESCustomerMsg> list = zgJdbcTemplate.query( sql, new RowMapper<ESCustomerMsg>(){

			@Override
			public ESCustomerMsg mapRow(ResultSet rs, int rowNum) throws SQLException {
				ESCustomerMsg msg = new ESCustomerMsg();
				msg.setBmBusinessType(rs.getString(""));
				return msg;
			}}, "获取资管客户信息");
		
		esJdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, list.get(i).getBmCustName());
				//.......
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
	}

}
