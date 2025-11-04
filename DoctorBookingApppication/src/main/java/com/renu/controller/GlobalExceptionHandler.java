package com.renu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {

	        // Extract field-specific error messages
	        Map<String, String> fieldErrors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> 
	            fieldErrors.put(error.getField(), error.getDefaultMessage())
	        );

	        // Build response body
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", new Date());
	        body.put("status", HttpStatus.BAD_REQUEST.value());
	        body.put("errors", fieldErrors);

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }

	    // Handle other exceptions (optional)
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGeneralExceptions(Exception ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", new Date());
	        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        body.put("error", ex.getMessage());

	        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
