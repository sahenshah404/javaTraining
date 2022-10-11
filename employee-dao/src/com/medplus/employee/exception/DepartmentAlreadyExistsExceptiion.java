package com.medplus.employee.exception;

@SuppressWarnings("serial")
public class DepartmentAlreadyExistsExceptiion extends RuntimeException{
	public DepartmentAlreadyExistsExceptiion() {
		super("The department already Exist");
	}
}
