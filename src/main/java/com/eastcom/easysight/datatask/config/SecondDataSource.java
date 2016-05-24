package com.eastcom.easysight.datatask.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@MapperScan(sqlSessionFactoryRef="zgSqlSessionFactory",basePackages="com.eastcom.easysight.zigaun.mapper" )
@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:../conf/application.properties", ignoreResourceNotFound = true) })
public class SecondDataSource {
	@Autowired
	private Environment env;

	@Bean(name = "zgDataSource")
	@ConfigurationProperties(prefix = "datasource.ziguan")
	public DataSource zgDataSource() {
		DataSourceBuilder creater = DataSourceBuilder.create();
		creater.driverClassName(env.getProperty("datasource.ziguan.driverClassName"))
			.url(env.getProperty("datasource.ziguan.url"))
			.username(env.getProperty("datasource.ziguan.username"))
			.password(env.getProperty("datasource.ziguan.password"));
		DataSource dataSource =creater.build();
		return dataSource;
	}

	@Bean(name="zgSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(DataSource zgDataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(zgDataSource());
		try {
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			return  null;
		}
	}
}
