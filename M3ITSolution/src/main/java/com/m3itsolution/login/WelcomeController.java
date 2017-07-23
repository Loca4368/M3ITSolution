package com.m3itsolution.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class WelcomeController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
	//	model.addAttribute("todos",service.retrieveTodos(retrieveLoggedinUserName()));
		model.addAttribute("user", service.getLoggedInUserName());
		return "welcome";
	}
	

}
