package com.in28minutes.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
		model.addAttribute("todos",service.retrieveTodos("Ming"));
		return "todo";
	}
	
	@RequestMapping(value ="/addtodo")
	public String addTodoPage(ModelMap model)
	{
		return "addtodo";
	}
	
	@RequestMapping(value ="/addtodo", method = RequestMethod.POST)
	public String handleAddTodoPage(@RequestParam String desc, ModelMap model)
	{
		service.addTodo("Ming",desc, new Date(), false);
		return "redirect:todo";
	}
	
	@RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
	public String handleDeleteTodo(@RequestParam int id, ModelMap model)
	{
		service.deleteTodo(id);
		model.clear();
		return "redirect:todo";
	}
	
}
