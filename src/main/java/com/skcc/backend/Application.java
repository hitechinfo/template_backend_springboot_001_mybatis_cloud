package com.skcc.backend;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	static DataSource dataSource;

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
		logger.info("Hello World!-Application-main-test");
	}
}