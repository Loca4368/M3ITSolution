package com.m3itsolution.security.config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Ming").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("Test").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Qiu").password("123456").roles("ADMIN","DBA");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	    http.sessionManagement()
    	    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    
      http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/**todo**","/**todo**/*").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .and().formLogin().loginPage("/login")
        .defaultSuccessUrl("/welcome", true)
        .failureUrl("/login?error")
        .usernameParameter("username").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}