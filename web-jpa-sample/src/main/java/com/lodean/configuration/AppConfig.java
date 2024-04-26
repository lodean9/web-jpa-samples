package com.lodean.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;

import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScans(value = {@ComponentScan(basePackages = "com.lodean.configuration.**", includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = Configuration.class) })
						, @ComponentScan(basePackages = "com.lodean.**.controller", includeFilters = {@Filter(classes = {Controller.class})})
						, @ComponentScan(basePackages = "com.lodean.**.dao", includeFilters = {@Filter(classes = {Repository.class})})
						, @ComponentScan(basePackages = "com.lodean.**.entity", includeFilters = {@Filter(classes = {Entity.class})})
						})
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig START");
	}
}
