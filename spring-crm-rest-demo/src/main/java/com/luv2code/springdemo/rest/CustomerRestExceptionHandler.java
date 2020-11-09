package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handlerException(CustomerNotFoundException e) {
		
		CustomerErrorResponse cer = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											e.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(cer, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handlerException(Exception e) {
		
		CustomerErrorResponse cer = new CustomerErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											e.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(cer, HttpStatus.BAD_REQUEST);
	}
}
