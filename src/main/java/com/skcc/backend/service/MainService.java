package com.skcc.backend.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.backend.dao.MainDao;

@Service("mainService")
public class MainService {

	private Logger logger = LoggerFactory.getLogger(MainService.class);

	@Autowired
	MainDao mainDao;


	/**
	* getTemplate
	*
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> getTemplate() throws Exception {
		try {
			return mainDao.getTemplate();
		} catch (Exception e) {
		  // TODO: handle exception
		  logger.error(">>>>>>>>>>>>>>>>>>>MyBatis Test Error Ser");
		  throw new Exception("MyBatis Test Error Ser");
		}
	}
}
