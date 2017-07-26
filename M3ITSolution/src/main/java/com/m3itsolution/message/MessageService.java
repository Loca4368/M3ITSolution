package com.m3itsolution.message;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.m3itsolution.login.LoginService;

@Service
public class MessageService {
	
	@Autowired
    MessageSource messageSource;
	
	@Autowired
	LoginService loginservice;
	
	//Get Login message
	public String getLoginMessage(String error) {
		
		// obtain locale from LocaleContextHolder
		Locale currentLocale = LocaleContextHolder.getLocale();
    	if(error != null)
    	{
    		
    		error = messageSource.getMessage("error.message", new Object[]{loginservice.getLoggedInUserName()},currentLocale);
         
    	}
    	return error;
    }
	
	//Get welcome message
	public String getWelcomeMessage(String userName) {
        
		// obtain locale from LocaleContextHolder
		Locale currentLocale = LocaleContextHolder.getLocale();
    	// add parametrized message from controller
        String welcomeMessage = messageSource.getMessage("welcome.message", new Object[]{userName}, currentLocale);
       
    	return welcomeMessage;
    }
}
