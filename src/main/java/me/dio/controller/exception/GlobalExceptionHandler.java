package me.dio.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBussinessException(IllegalArgumentException bussinessException) {
        return new ResponseEntity<>(bussinessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	
    }
	
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
		var message = "Resource ID not found.";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }
	
	@ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable UnexpectedException) {
		var message = "UnexpectedExceptio server found.";
		logger.error(message,UnexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);

    }
	

}
