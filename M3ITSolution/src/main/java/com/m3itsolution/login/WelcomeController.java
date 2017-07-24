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

@Controller
@SessionAttributes("user")
public class WelcomeController {
	
	@Autowired
	LoginService service;
	
	@Autowired
    private MessageSource messageSource;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model,Locale locale) {
		
		// add parametrized message from controller
        String welcome = messageSource.getMessage("welcome.message", new Object[]{service.getLoggedInUserName()}, locale);
        model.addAttribute("message", welcome);
        
        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);
        //model.addAttribute("startMeeting", "10:30");
	
        //Get logged in user
		model.addAttribute("user", service.getLoggedInUserName());
		return "welcome";
	}
	

}
