package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class UpdateEmployeeByCode {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter the employee code");
		int empcode = sc.nextInt();
		EmployeeService service = new EmployeeServiceImpl();
		
		System.out.println("Which column do you want to update");
		System.out.println("1: name");
		System.out.println("2: job");
		System.out.println("3: salary");
		int opt = sc.nextInt();
		sc.nextLine();
		
		if(opt == 1 || opt ==2) {
			if(opt==1) {
				
				System.out.println("Enter the new name");
				String newValue = sc.nextLine();
				service.updateEmpNameByCode(empcode, newValue);
			}
			if(opt==2) {
				System.out.println("Enter the new job");
				String newValue = sc.nextLine();
				service.updateEmpJobByCode(empcode, newValue);
			}
		}
		else if (opt==3) {
			System.out.println("Enter the new salary");
			Double salary = sc.nextDouble();
			service.updateEmpSalaryByCode(empcode, salary);
			
		}

	}

}
