package com.organization.university.custom.exception.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.organization.university.custom.exception.CustomException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class ApplicationException {
	

	 @ExceptionHandler(NullPointerException.class)
	    public ResponseEntity<Object> handleNullPointerException(
	    		NullPointerException ex, WebRequest request) {
		 log.error("Null Pointer Exception......................");
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "NullPointerException");
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(CustomException.class)
	    public ResponseEntity<Object> handleCustomException(
	    		CustomException ex, WebRequest request) {
		 log.error("CustomException Exception::::::::::::::::::::::::::::::::::::::::");
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", ex.getMessage());
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleCityException(
	    		Exception ex, WebRequest request) {
		 log.error("GlobalException Exception::::::::::::::::::::::::::::::::::::::::");
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("ex message", ex.getMessage());
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

	 

}
