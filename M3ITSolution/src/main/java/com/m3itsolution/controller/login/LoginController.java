package com.m3itsolution.controller.login;
 
import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import com.m3itsolution.model.User;
//import com.m3itsolution.service.LoginService;
import com.m3itsolution.service.MessageService;
//import com.m3itsolution.service.SecurityService;
//import com.m3itsolution.todo.TodoService;
import com.m3itsolution.service.UserService;
 
@Controller
public class LoginController {
 
//	@Autowired
//	LoginService loginService;
//	
	@Autowired
	UserService userService;
	
	@Autowired
    private MessageSource messageSource;
	
	@Autowired
	MessageService messageservice;
	
	
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
       
        return "welcome";
    	//return "redirect:welcome";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam (required= false) String error, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//    	String name = request.getParameter("username");
//    	if( name == null)
//    		return "login";
//    	User user = userService.getUserByName(name);
//    	System.out.println("Username:"+ user.getUsername());
//    	System.out.println("Password:"+ user.getPwd());
//    	
//    	RequestDispatcher rd = request.getRequestDispatcher("welcome");
//    	rd.forward(request, response);
//    	//String loginMessage = messageservice.getLoginMessage(error);
//    	//model.addAttribute("errorMessage", loginMessage);
//    	return null;
//    	String username  = userService.getPrincipal();
//    	User user = userService.getUserByName(username);
//    	System.out.println("Username:"+ user.getUsername());
//    	System.out.println("Password:"+ user.getPwd());
    	return "login";
    }
    
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginHandler(@RequestParam (required= false) String error, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  public String loginHandler(@RequestParam String username, String password, String error, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    	//String name = request.getParameter("username");
//    	if( username == null)
//    		return "login";
//    	User user = userService.getUserByName(username);
//    	System.out.println("Username:"+ user.getUsername());
//    	System.out.println("Password:"+ user.getPwd());
//    	
//    	RequestDispatcher rd = request.getRequestDispatcher("welcome");
//    	rd.forward(request, response);
//    	//String loginMessage = messageservice.getLoginMessage(error);
//    	//model.addAttribute("errorMessage", loginMessage);
//    	return null;
//    }
    
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(@RequestParam (required= false) String error, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	
//
//    	
//    	System.out.println("Start Login");
//    	//String loginMessage = messageservice.getLoginMessage(error);
//    	//model.addAttribute("errorMessage", loginMessage);
//    	return "login";
//    }
    
//// 
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(ModelMap model) {
//        
//    	model.addAttribute("user",loginService.getPrincipal());
//    	
//        return "admin";
//    }
//    
//    @RequestMapping(value = "/db", method = RequestMethod.GET)
//    public String dbaPage(ModelMap model) {
//        model.addAttribute("user", loginService.getPrincipal());
//        return "dba";
//    }
//    
// 
//    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
//    public String accessDeniedPage(ModelMap model) {
//        model.addAttribute("user",loginService.getPrincipal());
//        return "accessDenied";
//    }
// 
}