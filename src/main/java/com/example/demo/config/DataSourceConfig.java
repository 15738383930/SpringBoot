package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.example.demo.utils.CommUtil;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据源配置
 * com.zaxxer.hikari.HikariDataSource 
 * （Spring Boot 2.0 以上，默认使用此数据源），无需配置
 * @author zhouhao
 *
 */
//@Configuration
public class DataSourceConfig {
	
//	@Bean(name = "dataSource")
	public DataSource dataSource(Environment env) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty(CommUtil.Property.DATASOURCE_URL));
		ds.setUsername(CommUtil.Property.DATASOURCE_USERNAME);
		ds.setPassword(CommUtil.Property.DATASOURCE_PASSWORD);
		//Spring Boot版本从2.x开始默认加载数据库驱动类，不需配置。
		//ds.setDriverClassName(CommUtil.Property.DATASOURCE_DCN);
		return ds;
	}

}
