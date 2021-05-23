package com.cg.onlineflatrental11.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FlatRentalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(FlatRentalExceptionHandler.class);
	@ExceptionHandler(FlatBookingNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFlatBookingNotFoundException(FlatBookingNotFoundException ex) {
		logger.info("===In Exception Handler===");
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		logger.info("Exception has executed");
		return new ResponseEntity(error,HttpStatus.OK);
		
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		logger.info("===In Exception Handler===");
		logger.info("Exception has executed");
		return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
