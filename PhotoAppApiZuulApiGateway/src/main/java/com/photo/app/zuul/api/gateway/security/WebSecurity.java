package com.photo.app.zuul.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	// @Value("${gateway.ip}") 
	 //private String ipAddress;
	
	private final Environment env;
	@Autowired
	public WebSecurity(Environment env) {
	this.env=env;	
	}
	
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception {
	  //System.out.println("IP adress :: "+ipAddress);
	  //System.out.println("IP adress env :: "+env.getProperty("gateway.ip")); 
	  System.out.println("api.zuul.actuator.url.path    "+env.getProperty("api.zuul.actuator.url.path")); 
	  http.csrf().disable();
	  //http.headers().frameOptions().disable();
	  http.authorizeRequests() 
	  .antMatchers(HttpMethod.GET, env.getProperty("api.users.actuator.url.path")).permitAll()
	  .antMatchers(HttpMethod.GET, env.getProperty("api.zuul.actuator.url.path")).permitAll()
	  .antMatchers(HttpMethod.POST, env.getProperty("api.registration.url.path")).permitAll()
	//  .antMatchers(HttpMethod.GET, "/users-ws/users/status/check").permitAll()
	  .antMatchers(HttpMethod.POST, env.getProperty("api.login.url.path")).permitAll()
	  .anyRequest().authenticated()
	  .and()
	  .addFilter(new AuthrizationFilter(authenticationManager(), env));
	  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }
}
