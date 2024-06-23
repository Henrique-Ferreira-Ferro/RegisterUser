package com.cadastroUser.registerUser.exceptions;

import java.time.LocalDate;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpErrorExceptionHandler {
	
	private ResponseEntity<ApiError> buildErrorMessage(HttpStatus status, String message){
		var error = new ApiError(status.value(), message, LocalDate.now());
		return ResponseEntity.status(status).body(error);
	}
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError> badRequest(BadRequestException exception){
		return buildErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ApiError> notFound(ObjectNotFoundException exception){
		return buildErrorMessage(HttpStatus.NOT_FOUND, "Não foi possivel encontrar: " + exception.getMessage());
	}
	
	
}
