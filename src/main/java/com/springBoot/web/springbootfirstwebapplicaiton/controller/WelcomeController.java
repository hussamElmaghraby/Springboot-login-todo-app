package com.springBoot.web.springbootfirstwebapplicaiton.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WelcomeController {
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String ShowWelcomePage( ModelMap model ) {
		model.put("name" , getLogedinUsername());
		return ("welcome");
	}
	// when calling this method then it will get the loggedin user bean and form which i want to get his user name . ..
	private String getLogedinUsername() {
	Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if(principal instanceof UserDetails ) {
		return ((UserDetails) principal).getUsername();
	}
	return principal.toString();
	}
}
