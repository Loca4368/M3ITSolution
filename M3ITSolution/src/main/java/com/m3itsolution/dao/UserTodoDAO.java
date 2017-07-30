package com.m3itsolution.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.m3itsolution.model.Todo;


public interface UserTodoDAO {

	public List<Todo> retrieveTodos(String user);
	public Todo retrieveTodoById(int id);
	public void addTodo(Todo todo);
	public void updateTodo(Todo todo, int id);
	public void deleteTodo(int id);
	
	
	
}


