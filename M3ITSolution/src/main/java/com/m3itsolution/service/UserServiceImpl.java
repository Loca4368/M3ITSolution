package com.m3itsolution.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.m3itsolution.dao.RoleDAO;
import com.m3itsolution.dao.UserDAO;
import com.m3itsolution.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDao;
	
	@Autowired //Inject bean Using setter
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


	public void addUser(User user) {
		
		//this.userDao.addUser(user);
		user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
	    user.setRoles(new HashSet<>(roleDao.findAll()));
	    this.userDao.addUser(user);
	
	}
	
	@Override
	public User getUserByName(String name) {
		
		return this.userDao.getUserByName(name);
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
	
	@Override
	public String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


	@Override
	public String findLoggedInUsername(String username) {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
      if (userDetails instanceof UserDetails) {
          return ((UserDetails)userDetails).getUsername();
      }

      return null;

	}

}
