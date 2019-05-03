package com.skcc.backend.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<CustomError> handleDefault(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError customError = new CustomError(status, exception.getMessage());
		return new ResponseEntity<CustomError>(customError, status);
	}

}



