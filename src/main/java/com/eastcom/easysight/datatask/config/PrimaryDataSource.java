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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@MapperScan(sqlSessionFactoryRef="esSqlSessionFactory",basePackages="com.eastcom.easysight.sql.mapper")
@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:../conf/application.properties", ignoreResourceNotFound = true) })
public class PrimaryDataSource {
	@Autowired
	private Environment env;

	@Bean(name = "esDataSource")
	@Primary
	@ConfigurationProperties(prefix = "datasource.easysight")
	public DataSource esDataSource() {
		DataSourceBuilder creater = DataSourceBuilder.create();
		creater.driverClassName(env.getProperty("datasource.easysight.driverClassName"))
			.url(env.getProperty("datasource.easysight.url"))
			.username(env.getProperty("datasource.easysight.username"))
			.password(env.getProperty("datasource.easysight.password"));
		DataSource dataSource =creater.build();
		return dataSource;
	}
	
	
	@Bean(name="esSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(DataSource esDataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(esDataSource());
		try {
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			return  null;
		}
	}
}
