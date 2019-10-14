package com.m3itsolution.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.m3itsolution.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	// private static final Logger logger =
	// LoggerFactory.getLogger(UserDAOImpl.class);
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addUser(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public User getUserById(int id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}

	@Override
	public String getNameById(int id) {
		User user = hibernateTemplate.get(User.class, id);
		return user.getUsername();
	}

	@Override
	public User getUserByName(String name) {
		User user = hibernateTemplate.get(User.class, name);
		return user;
	}

	@Override
	public void removeUser(int id) {
		User user = new User();
		user.setId(id);
		hibernateTemplate.delete(user);
	}

	@Override
	public void updateUser(User user) {
		// Todo todo = hibernateTemplate.get(Todo.class,id);
		// todo.setDesc(desc);
		hibernateTemplate.update(user);
	}

	public List<User> listUsers() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		List<User> userList = (List<User>) hibernateTemplate.findByCriteria(criteria);
		return userList;
	}
}
