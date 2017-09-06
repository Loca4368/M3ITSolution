/*
 * SpringSecurityFilterChain
 * 
 *
 /*Spring Security Terms 
 *Principal– User, device or system that performs an action
*Authentication– Establishing that a principal’s credentials are valid
*Authorization– Deciding if a principal is allowed to perform an action
*Secured item– Resource that is being secured
*/

package com.m3itsolution.config.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.m3itsolution.dao.UserDAO;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 	
	@Autowired
//	@Qualifier("UserDetailsServiceImpl")
	UserDetailsService myUserDetailsService;
	
	@Autowired 
	private UserDAO userDao;
	
	@Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl(userDao);
    }
//	@Autowired
//	PersistentTokenRepository tokenRepository;
	
	
	//Authentication Configuration
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Ming").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("Test").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("Qiu").password("123456").roles("ADMIN","DBA");
//   	  auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider((AuthenticationProvider) authenticationManager());
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    	  auth.authenticationProvider(authenticationProvider());
    	  System.out.println("Configuring GlobalSecurity for authentication...");
   	
    }
    //Configuration on Http Security, Custom Form Login, Authorize Requests, Handling Logouts and LoginError Page...
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	//Seesion
    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    	
    	//Authorize
    	http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/**todo**","/**todo**/*").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .and().formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/welcome", true)
        .failureUrl("/login?error")
        .usernameParameter("username").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
    
	@Bean
  	public BCryptPasswordEncoder passwordEncoder() {
  		BCryptPasswordEncoder encoder = (BCryptPasswordEncoder) new BCryptPasswordEncoder();
	  return encoder;
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() throws Exception {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsServiceBean());
		System.out.println("Injecting UserDetailsServiceBean for AuthenticationProvider.....");
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

//	@Bean
//	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
//		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
//				"remember-me", userDetailsService, tokenRepository);
//		return tokenBasedservice;
//	}

//	@Bean
//	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
//		return new AuthenticationTrustResolverImpl();
//	}


    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception        
    {
        return super.authenticationManagerBean();
    }
}