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
	@Override
	public List<User> listUsers() {
		
		Criteria criteria = getSession().createCriteria(User.class);
		
		return (List<User>)criteria.list();
	}
	@Override
	public void addUser(User user) {
		
		getSession().persist(user);
		//logger.info("User add successfully, User Details="+p);
	}

	@Override
	public void updateUser(User user) {
		
		getSession().update(user);
		
	}

	@Override
	public User getUserById(int id) {
		
		User user = (User) getSession().get(User.class,id);
		return user;
	}

	@Override
	public void removeUser(int id) {
		
		User user = (User) getSession().get(User.class,id);
		getSession().delete(user);
	}
}
