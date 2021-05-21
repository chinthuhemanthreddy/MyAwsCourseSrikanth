package com.organization.Btech.contollers.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApplicationException {
	
	 @ExceptionHandler(NullPointerException.class)
	    public ResponseEntity<Object> handleCityNotFoundException(
	    		NullPointerException ex, WebRequest request) {
		 System.out.println("Srikanth Null Pointer Exception......................");
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "City not found");
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleCityNotFoundException(
	    		Exception ex, WebRequest request) {
		 System.out.println("Srikanth GlobalException Exception::::::::::::::::::::::::::::::::::::::::");
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "City not found");
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

}
