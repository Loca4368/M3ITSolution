package com.m3itsolution.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.m3itsolution.dao.UserDAO;
import com.m3itsolution.dao.UserTodoDAO;

@Service
//@Transactional
public class LoginService{
	
//	UserDAO userDao;
//	
//	@Autowired
//	public void setUserDao(UserDAO userDao) {
//		this.userDao = userDao;
//	}

	public String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	//
	public int getLoggedInUserId()
	{
		return 1;
		
	}

//	public int getLoggedInUserIdByName(String userName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
