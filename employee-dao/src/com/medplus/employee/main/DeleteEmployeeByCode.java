package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class DeleteEmployeeByCode {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService service = new EmployeeServiceImpl();
		System.out.println("Enter the Employee code");
		int code = sc.nextInt();
		int rows = service.deleteEmployeeByCode(code);
		System.out.println(rows + " Employee deleted");
	}

}
