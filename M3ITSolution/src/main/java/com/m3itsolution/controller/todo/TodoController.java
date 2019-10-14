package com.m3itsolution.controller.todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.m3itsolution.model.Todo;
import com.m3itsolution.service.TodoService;

@Controller
@RequestMapping(value = "/todo")
//@PreAuthorize("hasAuthority('USER')")
public class TodoController {

	@Autowired
	TodoService todoservice;

	/*
	 * Get user
	 */
//	//Use InitBinder for TargetDate field in todo form
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/*
	 * List all todos
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	// public ModelAndView list(@PathVariable String
	// username)----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public ModelAndView list() {
		// String user = loginservice.getLoggedInUserName();
		ModelAndView model = new ModelAndView("todo/list");
		// List<Todo> list = todoservice.retrieveTodos(user);
		List<Todo> list = todoservice.retrieveTodos(0);
		System.out.print("Processing");
		model.addObject("todoList", list);

		return model;
	}

	/*
	 * Add todo
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("todo/form");
		Todo todo = new Todo();
		model.addObject("todoForm", todo);

		return model;
	}

	/*
	 * Update
	 */

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateAndSave(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("todo/form");
		Todo todo = todoservice.retrieveTodoById(id);
		model.addObject("todoForm", todo);
		return model;

	}

	/*
	 * Delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		// ModelAndView model = new ModelAndView("todo/delete");
		todoservice.deleteTodo(id);

		return new ModelAndView("redirect:/todo/list");

	}

	/*
	 * Save
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView save(@ModelAttribute("todoForm") Todo todo, BindingResult result)
	public ModelAndView save(@ModelAttribute("todoForm") @Valid Todo todo, BindingResult result) {
		// todoservice.updateAndSaveTodo(desc, id);
		// todoservice.addTodo(todo);
		if (result.hasErrors()) {

			return new ModelAndView("todo/form");
		}

		else {
			if (todo.getId() == 0)
				todoservice.addTodo(todo);
			else
				todoservice.updateAndSaveTodo(todo);
			return new ModelAndView("redirect:/todo/list");
		}

	}
}
