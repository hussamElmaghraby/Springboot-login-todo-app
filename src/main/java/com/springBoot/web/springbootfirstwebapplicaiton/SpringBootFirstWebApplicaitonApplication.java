package com.springBoot.web.springbootfirstwebapplicaiton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.
@SpringBootApplication
@ComponentScan("com.springBoot")
public class SpringBootFirstWebApplicaitonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplicaitonApplication.class, args);
	}

}
