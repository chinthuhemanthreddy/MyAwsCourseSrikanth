package com.organization.university.custom.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3753103184787485395L;
	private final HttpStatus httpStatus;
	private final String message;
	
	public CustomException(String response, HttpStatus httpStatus) {
		super();
		this.message = response;
		this.httpStatus = httpStatus;
	}

}
