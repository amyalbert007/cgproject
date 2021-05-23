package com.cg.onlineflatrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LandlordExceptionHandler {
	@ExceptionHandler(LandlordNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleLandlordNotFoundException(LandlordNotFoundException ex) {
		//logger.info("===In Exception Handler===");
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		//logger.info("Exception has executed");
		return new ResponseEntity(error,HttpStatus.OK);
		
	}

	

}
