package com.springBoot.web.springbootfirstwebapplicaiton.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
@ExceptionHandler(Exception.class)
// this method gives me  an Exception details and Exception details -> which happen when the Exception is thrown 
public ModelAndView handlerException( HttpServletRequest req , Exception ex  ) {
	ModelAndView mv = new ModelAndView();
	// get the exception details .. 
	mv.addObject("Exception" , ex.getStackTrace());
	mv.addObject("url" , req.getRequestURI());
	mv.setViewName("Error");
	return mv;
}
}
