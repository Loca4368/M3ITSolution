package com.m3itsolution.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.m3itsolution.model.Todo;;

@Repository
public class UserTodoDAOImpl implements UserTodoDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addTodo(Todo todo) {
		hibernateTemplate.save(todo);
	}

	@Override
	public Todo retrieveTodoById(int id) {
		Todo todo = hibernateTemplate.get(Todo.class, id);
		return todo;
	}

	@Override
	public void deleteTodo(int id) {
		Todo todo = new Todo();
		todo.setId(id);

		hibernateTemplate.delete(todo);
	}

	// To be fixed
	/*
	 * @Override public void updateAndSaveTodo(String desc,int id) {
	 * 
	 * Todo todo = hibernateTemplate.get(Todo.class,id); todo.setDesc(desc);
	 * 
	 * hibernateTemplate.update(todo); }
	 */
	@Override
	public void updateAndSaveTodo(Todo todo) {

		// Todo todo = hibernateTemplate.get(Todo.class,id);
		// todo.setDesc(desc);

		hibernateTemplate.update(todo);

	}

	public List<Todo> retrieveTodos(String user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Todo.class);
		List<Todo> todoList = (List<Todo>) hibernateTemplate.findByCriteria(criteria);
		return todoList;
	}

	public List<Todo> retrieveTodos(int userId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Todo.class);
		List<Todo> todoList = (List<Todo>) hibernateTemplate.findByCriteria(criteria);
		return todoList;
	}

}
