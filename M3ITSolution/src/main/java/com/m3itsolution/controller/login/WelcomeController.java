package com.m3itsolution.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.m3itsolution.service.MessageService;
import com.m3itsolution.service.UserService;

@Controller
@SessionAttributes("user")
public class WelcomeController {

//	@Autowired
//	SecurityService securityService;

	@Autowired
	UserService userService;

	@Autowired
	MessageService messageservice;

//	@Autowired
//	LoginService loginService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {

		// securityService.autoLogin(username, password);
		// Get Logged username
		String userName = userService.getPrincipal();

		// Get message
		String welcomemessage = messageservice.getWelcomeMessage(userName);

		// Add message for View
		model.addAttribute("welcomemessage", welcomemessage);
		model.addAttribute("user", userName);

		return "welcome";
	}

}
