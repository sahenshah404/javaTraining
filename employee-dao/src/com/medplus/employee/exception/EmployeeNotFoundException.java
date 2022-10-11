package com.medplus.employee.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException() {
		super("Employe Record not found for given Emp Code");
	}
}
