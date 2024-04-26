package com.lodean.configuration.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Profile("local")
@Configuration
@PropertySource("classpath:properties/db-local.properties")
public class DataSourceProperties {
	
	@Autowired
	Environment env;
	
	@Value("${datasource.jdbc-url}")
	private String jdbcUrl;
	@Value("${datasource.username}")
	private String username;
	@Value("${datasource.password}")
	private String password;
	@Value("${datasource.driver-class-name}")
	private String driverClassName;
	@Value("${datasource.test-query}")
	private String testQuery;
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public String getTestQuery() {
		return testQuery;
	}

	public void setTestQuery(String testQuery) {
		this.testQuery = testQuery;
	}

	@Override
	public String toString() {
		return "DataSourceProperties [jdbcUrl=" + jdbcUrl + ", username=" + username + ", password=" + password
				+ ", driverClassName=" + driverClassName + ", testQuery=" + testQuery + "]";
	}
}
