package com.m3itsolution.service;

import java.util.List;

import com.m3itsolution.model.User;

public interface UserService {

	public void addUser(User user);

	public void updateUser(User p);

	public List<User> listUsers();

	public User getUserById(int id);

	public User getUserByName(String name);

	public void removeUser(int id);

	public String findLoggedInUsername(String username);

	String getPrincipal();

}