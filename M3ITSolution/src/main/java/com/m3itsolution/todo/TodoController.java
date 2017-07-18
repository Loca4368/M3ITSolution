package com.m3itsolution.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value ="/todo")
	public String showTodoPage(ModelMap model)
	{
		//model.addAttribute("todos",service.retrieveTodo(1));
		model.addAttribute("todos",service.retrieveTodos("Ming"));
		return "todo";
	}
	@RequestMapping(value ="/addtodo")
	public String shwoAddTodoPage(ModelMap model)
	{
		//Hardcode current user for dispaly
		model.addAttribute("todotask", new Todo(0,"Ming","",new Date(),false));
		return "addtodo";
	}
	
	
	@RequestMapping(value ="/addtodo", method = RequestMethod.POST)
	public String handleAddTodoPage(ModelMap model,@Valid Todo todo6, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addtodo";
		}
		service.addTodo("Ming",todo6.getDesc(), new Date(), false);
		return "redirect:todo";
	}
	
	//Handle delete
	@RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
	public String handleDeleteTodo(@RequestParam int id, ModelMap model)
	{
		service.deleteTodo(id);
		model.clear();
		return "redirect:todo";
	}
	
	//Handle update
	@RequestMapping(value ="/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model)
	{
		Todo todo2 = service.retrieveTodo(id);
		model.addAttribute("todotask",todo2);
		//model.clear();
		//return "redirect:todo";
		return "addtodo";
	}
	
	//Handle update
		@RequestMapping(value ="/update-todo", method = RequestMethod.POST)
		public String handleUpdadeTodo(ModelMap model, @Valid Todo todo2, BindingResult result)
		{
			if(result.hasErrors())
			{
				return "addtodo";
			}
			//Todo todo = service.retrieveTodo(id);
			//model.addAttribute("todo",todo);
			service.updateTodo(todo2);
			todo2.setUser("Ming");
			todo2.setTargetDate(new Date());
			return "redirect:todo";
		}
	
}
