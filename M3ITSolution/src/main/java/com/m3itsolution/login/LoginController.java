package com.m3itsolution.login;
 
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




import com.m3itsolution.service.LoginService;
import com.m3itsolution.service.MessageService;
//import com.m3itsolution.todo.TodoService;
 
@Controller
public class LoginController {
 
	@Autowired
	LoginService loginservice;
	
	@Autowired
    private MessageSource messageSource;
	
	@Autowired
	MessageService messageservice;
	
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
       
        return "welcome";
    	//return "redirect:welcome";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        
    	model.addAttribute("user",loginservice.getLoggedInUserName());
    	
        return "admin";
    }
    
    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", loginservice.getLoggedInUserName());
        return "dba";
    }
    
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", loginservice.getLoggedInUserName());
        return "accessDenied";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam (required= false) String error, ModelMap model) {
    	
    	
    	//String loginMessage = messageservice.getLoginMessage(error);
    	//model.addAttribute("errorMessage", loginMessage);
    	return "login";
    }
  
    
 
}