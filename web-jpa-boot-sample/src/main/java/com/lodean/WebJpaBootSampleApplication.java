package com.lodean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScans(value = {@ComponentScan(basePackages = "com.lodean.**.controller", includeFilters = {@Filter(classes = {Controller.class})})
						, @ComponentScan(basePackages = "com.lodean.**.dao", includeFilters = {@Filter(classes = {Repository.class})})
						, @ComponentScan(basePackages = "com.lodean.**.entity", includeFilters = {@Filter(classes = {Entity.class})})
						})
public class WebJpaBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebJpaBootSampleApplication.class, args);
	}

}
