package com.medplus.employee.exception;

@SuppressWarnings("serial")
public class DepartmentNotFoundException extends RuntimeException{

	public DepartmentNotFoundException() {
		super("No Department Found for given Department input");
	}
}
