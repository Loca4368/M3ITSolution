package com.m3itsolution.dao;

import java.util.List;

import com.m3itsolution.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listUsers();
	public User getUserById(int id);
	public User getUserByName(String name);
	public void removeUser(int id);
	
	//Get name
	public String getNameById(int id);

}
