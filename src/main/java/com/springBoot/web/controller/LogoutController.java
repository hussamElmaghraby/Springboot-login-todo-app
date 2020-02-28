package com.springBoot.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class LogoutController {
	@Autowired
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String ShowWelcomePage( HttpServletRequest req , HttpServletResponse res ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//if the user have already authenticated you can log him  out.
		if(auth !=null ) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		return ("redirect:/");
	}
}
