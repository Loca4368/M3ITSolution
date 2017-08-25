package com.m3itsolution.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.m3itsolution.model.Todo;


public interface UserTodoDAO {

	public List<Todo> retrieveTodos(String user);
	public List<Todo> retrieveTodos(int userId);
	public Todo retrieveTodoById(int id);
	public void addTodo(Todo todo);
	//public void updateAndSaveTodo(String desc,int id);
	//public void updateAndSaveTodo(String desc,int id);
	public void updateAndSaveTodo(Todo todo);
	public void deleteTodo(int id);
}


