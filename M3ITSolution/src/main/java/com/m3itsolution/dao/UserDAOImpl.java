package com.m3itsolution.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3itsolution.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sf;
	
	private Session getSession()
	{
		//return sessionFactory.getCurrentSession();
		return sf.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	
	public List<User> listUsers() {
		
		Criteria criteria = getSession().createCriteria(User.class);
		
		return (List<User>)criteria.list();
	}
	
	public void addUser(User user) {
		
		getSession().persist(user);
		//logger.info("User add successfully, User Details="+p);
	}

	
	public void updateUser(User user) {
		
		getSession().update(user);
		
	}

	
	public User getUserById(int id) {
		
		User user = (User) getSession().get(User.class,id);
		return user;
	}

	
	public void removeUser(int id) {
		
		User user = (User) getSession().get(User.class,id);
		getSession().delete(user);
	}
	
	//Get name
	public String getNameById(int id)
	{
		return (String) getSession().get("username", id);
		
	}
}
