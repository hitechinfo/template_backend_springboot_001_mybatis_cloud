package com.skcc.backend.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
* Spring Security Configuration
*
*
*
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityEntryPoint securityEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2console/**");
		web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger/**");
	}
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	     .csrf()
		.disable()
	     .exceptionHandling()
	        .authenticationEntryPoint(securityEntryPoint)
		.and()
	     .authorizeRequests()
	     .antMatchers("/*").permitAll()
	     .antMatchers("/*/*").permitAll()
	     .antMatchers("/v2/api-docs", "/swagger-resources", "/configuration/**", "/swagger*.**", "/webjars/**").permitAll()
   		 .anyRequest().authenticated()
		 .and()
	     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}