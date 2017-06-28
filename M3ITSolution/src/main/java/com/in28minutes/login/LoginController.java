package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
	
	@Autowired
	LoginService service;
	
//	@RequestMapping(value = "/")
//	public String Hello()
//	{
//		return "login";
//	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String ShowLoginPage()
	{
		return "login";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public String HandleLoginRequest(@RequestParam String name,@RequestParam String password, ModelMap model)
	{
		//LoginService service = new LoginService();
		
		
		if(!service.validateUser(name, password))
		{
			model.put("errorMessage","Invalid Credentatials");
			return "login";
		}
		model.put("currentUser", name);
		//model.put("password", password);
		return "welcome";
	}

}
