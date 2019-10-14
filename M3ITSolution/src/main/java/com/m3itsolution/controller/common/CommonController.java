package com.m3itsolution.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	/*
	 * @RequestMapping(value = "/") public String showWelcomePage() { return
	 * "welcome"; }
	 */

//	@RequestMapping(value = "/register")
//	public String showRegisterPage()
//	{
//		return "register";
//	}
	@RequestMapping(value = "/about")
	public String showAboutPage() {
		return "about";
	}

	@RequestMapping(value = "/news")
	public String showNewsPage() {
		return "news";
	}

	@RequestMapping(value = "/contact")
	public String showContactPage() {
		return "contact";
	}

}
