package com.m3itsolution.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	MessageSource messageSource;

	/*
	 * Get Login message
	 */
	public String getLoginMessage(String error) {

		// obtain locale from LocaleContextHolder
		Locale currentLocale = LocaleContextHolder.getLocale();
		if (error != null) {
//    		error = messageSource.getMessage("error.message", new Object[]{sercurityService.findLoggedInUsername()},currentLocale);
			error = messageSource.getMessage("error.message", null, currentLocale);
		}
		return error;
	}

	/*
	 * Get welcome message
	 */
	public String getWelcomeMessage(String userName) {

		// obtain locale from LocaleContextHolder
		Locale currentLocale = LocaleContextHolder.getLocale();
		// add parametrized message from controller
		String welcomeMessage = messageSource.getMessage("welcome.message", new Object[] { userName }, currentLocale);

		return welcomeMessage;
	}
}
