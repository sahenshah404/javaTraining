package com.medplus.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionshandler {

	@ExceptionHandler(value = EmptyDepartmentException.class)
	public ResponseEntity<Object> exception(EmptyDepartmentException exp) {
		return new ResponseEntity<Object>("Department Table is Empty !!!", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DepartmentExistException.class)
	public ResponseEntity<Object> exception(DepartmentExistException exp) {
		return new ResponseEntity<Object>("Department Already Exist!!!", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = DepartmentNotFoundException.class)
	public ResponseEntity<Object> exception(DepartmentNotFoundException exp) {
		return new ResponseEntity<Object>("Department Not Found", HttpStatus.NOT_FOUND);
	}
}
