package com.skcc.backend;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.skcc.backend.common.data.jpa.entity.TemplateAuth;
import com.skcc.backend.common.data.jpa.repository.TemplateAuthRepository;

@Component
public class H2Runner implements ApplicationRunner
{

	@Autowired
	DataSource dataSource;

	@Autowired
	TemplateAuthRepository templateAuthRepository;

	//@Autowired
	//TemplateAuth templateAuth;

	private Logger logger = LoggerFactory.getLogger(H2Runner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		// TODO Auto-generated method stub
//		try(Connection concection = dataSource.getConnection()){ //H2 DB Connection
//
//		TemplateAuth templateAuth = new TemplateAuth();
//		//JPA TABLE INSERT AUTH
//		templateAuth.setAuthUserId("admin");
//		templateAuth.setAuthUserPw("admin");
//		templateAuth.setAuthUserType("admin");
//		templateAuthRepository.save(templateAuth);
//		}
	}
}