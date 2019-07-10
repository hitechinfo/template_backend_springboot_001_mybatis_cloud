package com.skcc.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.backend.common.security.CustomUserDetailsService;
import com.skcc.backend.service.MainService;

@RestController
public class MainController {

	@Autowired
	MainService mainService;


	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	private Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	*MainTemplate
	*
	*@return
	*/
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ResponseEntity<String> getHome() {

		logger.info("logback example - info level");
		logger.debug("logback example - debug level");

		return new ResponseEntity<String>("Hello World!-MainController-main", HttpStatus.OK);
	}

	/**
	* AuthTemplate
	*
	* @param req
	 * @param authentication 
	* @return UserDetails
	*/
	@RequestMapping("/auth")
	public UserDetails authTemplate(@RequestBody Map<String, Object> req, HttpSession session){

		logger.info("Hello World!-authTemplate{}_jpa", req);

		customUserDetailsService.createAccount(req.get("TEMPLATE_USER_ID").toString(), req.get("TEMPLATE_USER_PW").toString(),req.get("TEMPLATE_USER_TYPE").toString());

		UserDetails auth = customUserDetailsService.loadUserByUsername(req.get("TEMPLATE_USER_ID").toString());

		String authUserId = req.get("TEMPLATE_USER_ID").toString();
		String authUserPw = req.get("TEMPLATE_USER_PW").toString();
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUserId, authUserPw));
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

		return auth;
	}

	/**
	* MyBatisTemplate
	*
	* @return Map<String, Object>
	* @throws Exception
	*/
	@RequestMapping("/data")
	@ResponseBody
	public Map<String, Object> getTemplate() throws Exception{
		logger.info("Hello World!-getTemplate-data-req_MariaDB");

		ArrayList<Map<String, Object>> resultIt = (ArrayList<Map<String, Object>>) mainService.getTemplate();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			resultMap.put("rows", resultIt);
			logger.info("Hello World!-getTemplate-data-returnMap{}", resultMap);
		} catch (Exception e) {
			logger.error(">>>>>>>>>>>>>>>>>>MyBatis Test Error Con");
			throw new Exception("MyBatis Test Error Con");
		}

		return resultMap;
	}

	/**
	* JPATemplate
	*
	*@return void
	*@throws Exception
	*/
	@RequestMapping("/datajpa")
	public void getTemplateJpa() throws Exception {
		mainService.getTemplateJpa();
	}
	
	/**
	* ExceptionTemplate
	*
	*@throws Exception
	*/
	@RequestMapping("/exception")
	public void getTemplateException() throws Exception {
		logger.error(">>>>>>>>>>>>>>>>>Exception Test Error");
		throw new Exception("Exception Test Error!");
	}

}
	