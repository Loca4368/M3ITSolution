package com.m3itsolution.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3itsolution.dao.UserTodoDAO;
import com.m3itsolution.model.Todo;;

@Service
@Transactional
public class TodoServiceImpl implements TodoService{

	
	UserTodoDAO UserTodoDao;
	
	@Autowired
	public void setUserTodoDao(UserTodoDAO userTodoDao) {
		UserTodoDao = userTodoDao;
	}

	@Override
	public List<Todo> retrieveTodos(String user) {
		
		return this.UserTodoDao.retrieveTodos(user);
	}

	@Override
	public Todo retrieveTodoById(int id) {
		return this.UserTodoDao.retrieveTodoById(id);
	}

	@Override
	public void addTodo(Todo todo) {
		
		this.UserTodoDao.addTodo(todo);
	}
	
	//To be fixed
	@Override
	public void updateTodo(Todo todo) {
		
		this.UserTodoDao.updateTodo(todo, 0);
	}

	@Override
	public void deleteTodo(int id) {
		
		this.UserTodoDao.deleteTodo(id);
	}

}
