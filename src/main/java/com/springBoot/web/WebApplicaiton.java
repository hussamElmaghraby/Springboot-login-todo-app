package com.springBoot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.
@SpringBootApplication
@ComponentScan("com.springBoot")
public class WebApplicaiton {

	public static void main(String[] args) {
		SpringApplication.run(WebApplicaiton.class, args);
	}

}
