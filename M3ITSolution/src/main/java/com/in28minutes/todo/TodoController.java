package com.in28minutes.todo;

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
		model.addAttribute("todos",service.retrieveTodos("Ming"));
		return "todo";
	}
	@RequestMapping(value ="/addtodo")
	public String shwoAddTodoPage(ModelMap model)
	{
		model.addAttribute("todo", new Todo(0,"Ming","",new Date(),false));
		return "addtodo";
	}
	
	
	@RequestMapping(value ="/addtodo", method = RequestMethod.POST)
	public String handleAddTodoPage(ModelMap model,@Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addtodo";
		}
		service.addTodo("Ming",todo.getDesc(), new Date(), false);
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
