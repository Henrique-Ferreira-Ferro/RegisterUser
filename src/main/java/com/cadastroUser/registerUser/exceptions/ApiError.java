package com.cadastroUser.registerUser.exceptions;

import java.time.LocalDate;

public class ApiError {
	
	private int statusCode;
	private String message;
	private LocalDate date;
	
	public ApiError() {
		
	}

	public ApiError(int statusCode, String message, LocalDate date) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.date = date;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
