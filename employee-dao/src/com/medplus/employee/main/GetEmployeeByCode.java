package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class GetEmployeeByCode {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService service = new EmployeeServiceImpl();
		Employee employee ;
		System.out.println("Enter your employee code");
		int empcode = sc.nextInt();
		
		employee =  service.getEmployeeByCode(empcode);
		
		if(employee!=null) {
			System.out.println(employee);			
		}
		  
	}
}
