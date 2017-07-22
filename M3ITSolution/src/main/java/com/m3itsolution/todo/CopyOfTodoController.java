package com.m3itsolution.todo;

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

@Controller
public class CopyOfTodoController {
	
	@Autowired
	TodoService service;
	
	
	/*
	 *Get user
	 */

	private String retrieveLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();
		
		return principal.toString();
	}
	
	
	//Use InitBinder for TargetDate field in todo form
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
	
	
	/*
	 *List all todo
	 */
	
	@RequestMapping(value ="/core/todo")
	public String showTodoPage(ModelMap model)
	{
		//model.addAttribute("todos",service.retrieveTodo(1));
		model.addAttribute("todos",service.retrieveTodos(retrieveLoggedinUserName()));
		return "/core/todo";
	}


	
	 /*
	 * Add todo
	 */
	
	@RequestMapping(value ="/core/addtodo")
	public String shwoAddTodoPage(ModelMap model)
	{
		//Hardcode current user for dispaly
		model.addAttribute("todo", new Todo(0,retrieveLoggedinUserName(),"",new Date(),false));
		return "/core/addtodo";
	}
	
	
	@RequestMapping(value ="/core/addtodo", method = RequestMethod.POST)
	public String handleAddTodoPage(ModelMap model,@Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "/core/addtodo";
		}
		service.addTodo(retrieveLoggedinUserName(),todo.getDesc(), new Date(), false);
		return "redirect:/core/todo";
	}
	
	//Handle delete
	@RequestMapping(value ="/core/delete-todo", method = RequestMethod.GET)
	public String handleDeleteTodo(@RequestParam int id, ModelMap model)
	{
		service.deleteTodo(id);
		model.clear();
		return "redirect:/core/todo";
	}
	
	/*
	* Update todo
	*/
	
	@RequestMapping(value ="/core/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model)
	{
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo",todo);
		//model.clear();
		//return "redirect:todo";
		return "/core/addtodo";
	}
	
	@RequestMapping(value ="/core/update-todo", method = RequestMethod.POST)
	public String handleUpdadeTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "/core/addtodo";
		}
		//Todo todo = service.retrieveTodo(id);
		//model.addAttribute("todo",todo);
		service.updateTodo(todo);
		todo.setUser(retrieveLoggedinUserName());
		//todo.setTargetDate(new Date());
		return "redirect:/core/todo";
	}
	
}
