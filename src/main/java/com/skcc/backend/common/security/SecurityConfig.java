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
	     .antMatchers("/main").permitAll()
	     .antMatchers("/auth").permitAll()
	     .antMatchers("/data").permitAll()
	     .antMatchers("/datajpa").permitAll()
		.anyRequest().authenticated()
		.and()
	     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}