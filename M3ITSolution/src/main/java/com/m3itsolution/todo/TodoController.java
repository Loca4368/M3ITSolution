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

import com.m3itsolution.model.Todo;
import com.m3itsolution.service.LoginService;
import com.m3itsolution.service.TodoService;


@Controller
public class TodoController {
	
	@Autowired
	TodoService todoservice;
	
	@Autowired
	LoginService loginservice;
	
	/*
	 *Get user
	 */
	
	
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
	
	@RequestMapping(value ="/todo")
	public String showTodoPage(ModelMap model)
	{
		//model.addAttribute("todos",service.retrieveTodo(1));
		model.addAttribute("todos",todoservice.retrieveTodos(loginservice.getLoggedInUserName()));
		return "todo";
	}

	
	 /*
	 * Add todo
	 */
	
	@RequestMapping(value ="/addtodo")
	public String shwoAddTodoPage(ModelMap model)
	{
		//Hardcode current user for dispaly
		model.addAttribute("todo", new Todo(0,loginservice.getLoggedInUserName(),"",new Date(),false));
		return "addtodo";
	}
	
	
	@RequestMapping(value ="/addtodo", method = RequestMethod.POST)
	public String handleAddTodoPage(ModelMap model,@Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addtodo";
		}
		//todoservice.addTodo(loginservice.getLoggedInUserName(),todo.getDesc(), new Date(), false);
		todoservice.addTodo(todo);

		return "redirect:todo";
	}
	
	//Handle delete
	@RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
	public String handleDeleteTodo(@RequestParam int id, ModelMap model)
	{
		todoservice.deleteTodo(id);
		model.clear();
		return "redirect:todo";
	}
	
	/*
	* Update todo
	*/
	
	@RequestMapping(value ="/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model)
	{
		Todo todo = todoservice.retrieveTodoById(id);
		model.addAttribute("todo",todo);
		//model.clear();
		//return "redirect:todo";
		return "addtodo";
	}
	
	@RequestMapping(value ="/update-todo", method = RequestMethod.POST)
	public String handleUpdadeTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addtodo";
		}
		//Todo todo = service.retrieveTodo(id);
		//model.addAttribute("todo",todo);
		todoservice.updateTodo(todo);
		todo.setUser(loginservice.getLoggedInUserName());
		//todo.setTargetDate(new Date());
		return "redirect:todo";
	}
	
}
