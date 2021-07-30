package com.task.eCommerce.error;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(TransactionsNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTransactionsNotFoundException(TransactionsNotFoundException exception){
		ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setDetails(String.valueOf(exception.getStatus().value()));
        return new ResponseEntity<ErrorDetails>(errorDetails, exception.getStatus());
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleUserAlreadyExistException(UserAlreadyExistException exception){
		ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setDetails(String.valueOf(exception.getStatus().value()));
        return new ResponseEntity<ErrorDetails>(errorDetails, exception.getStatus());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception){
		ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setDetails(String.valueOf(exception.getStatus().value()));
        return new ResponseEntity<ErrorDetails>(errorDetails, exception.getStatus());
	}
	
	@ExceptionHandler(TransactionsCannotBeCompletedException.class)
	public ResponseEntity<ErrorDetails> handleTransactionsCannotBeCompletedException(TransactionsCannotBeCompletedException exception){
		ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setDetails(String.valueOf(exception.getStatus().value()));
        return new ResponseEntity<ErrorDetails>(errorDetails, exception.getStatus());
	}
}
