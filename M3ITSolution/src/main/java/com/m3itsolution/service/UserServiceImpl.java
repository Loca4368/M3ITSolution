package com.m3itsolution.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3itsolution.dao.UserDAO;
import com.m3itsolution.model.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	UserDAO userDao;
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	public void addUser(User user) {
		
		this.userDao.addUser(user);
	
	}

	
	public void updateUser(User user) {
		
		this.userDao.updateUser(user);
		
	}

	
	public List<User> listUsers() {
		
		return this.userDao.listUsers();
	}

	
	public User getUserById(int id) {
		
		return this.userDao.getUserById(id);
		
	}

	
	public void removeUser(int id) {
		
		this.userDao.removeUser(id);
	}

}
