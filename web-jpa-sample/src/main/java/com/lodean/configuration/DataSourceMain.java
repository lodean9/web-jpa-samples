package com.lodean.configuration;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lodean.configuration.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceMain {
	
	private DataSource dataSource;
	
	@Bean
	public DataSource getDataSource(@Autowired HikariConfig hikariConfig) {
		if(Objects.isNull(dataSource)) {
			dataSource = new HikariDataSource(hikariConfig);
		}
		return dataSource;
	}
	
	@Bean
	public HikariConfig hikariConfig(@Autowired DataSourceProperties properties) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(properties.getJdbcUrl());
		config.setDriverClassName(properties.getDriverClassName());
		config.setUsername(properties.getUsername());
		config.setPassword(properties.getPassword());
		config.setConnectionTestQuery(properties.getTestQuery());
		
		return config;
	}
	
}
