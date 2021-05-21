package com.photo.app.users.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.photo.app.users.service.UserService;

/*
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @EnableWebSecurity
 * 
 * @Configuration public class WebSecurity extends WebSecurityConfigurerAdapter
 * {
 * 
 * @Value("${gateway.ip}") private String ipAddress;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * System.out.println("IP adress :: "+ipAddress); http.csrf().disable();
 * http.authorizeRequests().antMatchers("/**").hasIpAddress(ipAddress); }
 * 
 * }
 */
@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter{
	  
	  @Value("${gateway.ip}") private String ipAddress;
	  
	  private UserService userService;
	  
	  private BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  private Environment environment;

	  WebSecurity(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService, Environment environment){
		  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		  this.userService = userService;
		  this.environment = environment;
	  }
	  
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception {
	  System.out.println("IP adress :: "+ipAddress); 
	  http.csrf().disable();
	  http.authorizeRequests().antMatchers("/**").permitAll().and().
	  addFilter(getAuthenticationFilter());
	  }

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService,environment,authenticationManager());
		//authenticationFilter.setAuthenticationManager(authenticationManager());
		authenticationFilter.setFilterProcessesUrl("/users/login");
		return authenticationFilter;
	}
	  
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
		}
	  
}
