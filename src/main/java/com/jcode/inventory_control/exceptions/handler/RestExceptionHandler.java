package com.jcode.inventory_control.exceptions.handler;

import com.jcode.inventory_control.exceptions.ExceptionResponse;

import com.jcode.inventory_control.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerAllException(Exception exception, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				exception.getMessage(),
				webRequest.getDescription(false)
		);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception exception, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
				exception.getMessage(),
				webRequest.getDescription(false)
		);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(InvalidJwtAuthenticationException.class)
//	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAutentication(Exception exception, WebRequest webRequest) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse(
//				new Date(),
//				exception.getMessage(),
//				webRequest.getDescription(false)
//		);
//		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
//	}
}
