package com.lodean.configuration;

import java.util.Objects;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@EnableJpaRepositories(basePackages = "com.lodean.**.dao", entityManagerFactoryRef = "entityManagerFactory" )
public class JpaConfig {

	PersistenceExceptionTranslationPostProcessor persistencePostProcessor;

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceAnnotationBeanPostProcessor() {
		if(Objects.isNull(persistencePostProcessor)) 
			persistencePostProcessor = new PersistenceExceptionTranslationPostProcessor();
		return persistencePostProcessor;
	}
	
	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource, @Qualifier("jpaProperties") Properties jpaProperties) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		factoryBean.setDataSource(dataSource);
		//factoryBean.setPersistenceUnitName("tester");
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("com.lodean.**.dao**");
		//factoryBean.setPersistenceProviderClass((Class<? extends PersistenceProvider) SpringHibernateJpaPersistenceProvider.class);
		factoryBean.setJpaProperties(jpaProperties);
		factoryBean.afterPropertiesSet();
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(@Autowired LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory.getNativeEntityManagerFactory());
	}
	
	@Bean("jpaProperties")
	public Properties jpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		//properties.setProperty("hibernate.dialect", dialect);
		properties.setProperty("hibernate.show_sql", "true");
		
		return properties;
	}
}
