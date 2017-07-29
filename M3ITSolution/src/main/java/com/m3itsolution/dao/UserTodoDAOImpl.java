package com.m3itsolution.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.m3itsolution.model.Todo;;

@Repository
public class UserTodoDAOImpl implements UserTodoDAO{
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "Ming", "Learn Spring MVC", new Date(),
				false));
		todos.add(new Todo(2, "Ming", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "Ming", "Learn Hibernate", new Date(),
				false));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	@Override
	public Todo retrieveTodoById(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}
	
	
	//Todo
	@Override
	public void addTodo(Todo todo) {
		
		//todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
		todos.add(todo);
		
	}

	@Override
	public void updateTodo(Todo todo) {
		
		todos.remove(todo);
		todos.add(todo);
		
	}

	@Override
	public void deleteTodo(int id) {
		
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
		
	}

}
