package com.m3itsolution.service;

import java.util.List;

import com.m3itsolution.model.Todo;


public interface TodoService {
	
	//public List<Todo> retrieveTodos(String user);
	public List<Todo> retrieveTodos(int userID);
	public Todo retrieveTodoById(int id);
	public void addTodo(Todo todo);
	//public void updateAndSaveTodo(String desc,int id);
	public void updateAndSaveTodo(Todo todo);
	public void deleteTodo(int id);

}
