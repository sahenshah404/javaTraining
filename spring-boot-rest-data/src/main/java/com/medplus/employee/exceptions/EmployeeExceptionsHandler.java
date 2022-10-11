package com.medplus.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionsHandler {
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException exp) {
		return new ResponseEntity<Object>("Employee NOT Found", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> exception(EmployeeExistException exp) {
		return new ResponseEntity<Object>("Employee Already Exist!!!", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exp) {
		return new ResponseEntity<Object>("USER NOT Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = IncorrectPasswordException.class)
	public ResponseEntity<Object> exception(IncorrectPasswordException exp) {
		return new ResponseEntity<Object>("Incorrect password", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = UserNotCreatedException.class)
	public ResponseEntity<Object> exception(UserNotCreatedException exp) {
		return new ResponseEntity<Object>("User not created", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
