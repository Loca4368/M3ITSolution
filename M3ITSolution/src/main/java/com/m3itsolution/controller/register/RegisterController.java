package com.m3itsolution.controller.register;

import java.beans.PropertyEditor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.m3itsolution.model.User;
//import com.m3itsolution.service.SecurityService;
import com.m3itsolution.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	SecurityService securityService;
//	
	@Autowired
    private UserValidator userValidator;
	
	@RequestMapping(value ="/register",method = RequestMethod.GET)
	public ModelAndView register()
	{
		ModelAndView model = new ModelAndView("regForm");
		User user = new User();
		model.addObject("regForm", user);
		return model;
		
	}
	
	@RequestMapping(value ="/register",method = RequestMethod.POST)
//	public ModelAndView save(@ModelAttribute("regForm") User newUser, BindingResult result)
	public ModelAndView save(@ModelAttribute("regForm") User newUser)

	{
//      userValidator.validate(newUser,result);
//
//      if (result.hasErrors()) {
//    	  
//    	  return new ModelAndView("regForm");
//      }
//	  
	  System.out.println("UseID is:"+newUser.getId() +"Username is:" +newUser.getUsername()+ "Password:"+newUser.getPwd());

      userService.addUser(newUser);

//      securityService.autoLogin(newUser.getUsername(), newUser.getConfirmPwd());

      return new ModelAndView("redirect:/welcome");
		
	}

}
