package com.m3itsolution.login;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.m3itsolution.message.MessageService;

@Controller
@SessionAttributes("user")
public class WelcomeController {
	
	@Autowired
	LoginService service;
	
	@Autowired
	MessageService messageservice;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		
		//Get Logged username
		String userName  = service.getLoggedInUserName();
		
		//Get message
		String welcomemessage= messageservice.getWelcomeMessage(userName);
		
		//Add message for View
		model.addAttribute("welcomemessage", welcomemessage);
        model.addAttribute("user", userName);
		
        return "welcome";
	}
	

}
