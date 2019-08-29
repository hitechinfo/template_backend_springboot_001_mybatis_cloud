package com.skcc.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.backend.service.MainService;

import io.swagger.annotations.Api;

@Api(value="v1")
@RestController
public class MainController {

	@Autowired
	MainService mainService;

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

		return new ResponseEntity<String>("Hello World!-MainController-main-cloudVer", HttpStatus.OK);
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
	