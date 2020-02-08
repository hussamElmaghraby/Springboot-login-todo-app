package com.springBoot.web.springbootfirstwebapplicaiton.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.web.model.Todo;
import com.springBoot.web.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//Date - dd/mm/yyyy i want to use this Format .. when i doing something with the Date it will be displaying with this format 
		SimpleDateFormat dateFormat   = new SimpleDateFormat("dd/mm/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat ,false));
		
	}

	@RequestMapping(value = "/list-todo", method = RequestMethod.GET)
	public String ShowTodos(ModelMap model) {
		String name = getLoggedinUserName();
		model.put("todos", todoService.retrieveTodos(name));
		return "list-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String ShowAddTodos(ModelMap model) {
		model.addAttribute("todo" , new Todo( 0 , getLoggedinUserName() , "default Desc" , new Date() , false));
		return "/add-todo";
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String AddTodos(ModelMap model, @Valid Todo  todo , BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		// using Todo as command bean ..
		String name = getLoggedinUserName();
		// accessing the desc form the command bean
		todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id , ModelMap model ) {
		Todo todo = todoService.retrieveTodo(id);
		model.put("todo" , todo);
		return "add-todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo( ModelMap model, @Valid Todo todo , BindingResult result  ) {
	// every thing should be after the validation..
		if(result.hasErrors()) {
			return "add-todo";
		}
		todo.setUser(getLoggedinUserName());
		todoService.updateTodo(todo);
		return "redirect:/list-todo";
	}
}
