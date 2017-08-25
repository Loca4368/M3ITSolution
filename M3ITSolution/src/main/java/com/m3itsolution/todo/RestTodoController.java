package com.m3itsolution.todo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m3itsolution.model.Todo;
import com.m3itsolution.service.TodoService;

@RestController
public class RestTodoController {
	
	@Autowired
	private TodoService todoservice;

	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
//		List<Todo> users = todoservice.retrieveTodos("Ming");
//		return users;
		return null;
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable("id") int id) {
		return todoservice.retrieveTodoById(id);
	}
}
