package com.medplus.employee.exception;

@SuppressWarnings("serial")
public class DepartmentClosedException extends RuntimeException{
public DepartmentClosedException() {
	super("This department has been closed");
}
}
