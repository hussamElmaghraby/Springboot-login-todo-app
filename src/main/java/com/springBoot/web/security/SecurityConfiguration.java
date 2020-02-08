package com.springBoot.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	// we will need to override to methods .. 
	// first Create Users .. Hussam / 123 
	// second Create a login Page .. when the user is unAuthorized ..
	
	// we are going to use in memory authentication ..
	@Autowired
	public void ConfigureGlobalSecurity(AuthenticationManagerBuilder auth) 
		throws Exception {
			auth.inMemoryAuthentication().withUser("hussam").password("{noop}hiii").roles("USER" , "ADMIN");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/" , "/*todo*/**").access("hasRole('USER')").and().formLogin();
	} 
}
