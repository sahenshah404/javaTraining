package com.medplus.employee.main;

import java.util.HashMap;
//import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class SalaryBreakup {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Map<String, Double> salBreakup = new HashMap<String, Double>();
		EmployeeService empService = new EmployeeServiceImpl();
		System.out.println("Enter your emp code");
		int empcode = sc.nextInt();
		salBreakup.putAll(empService.calculateNetPay(empcode));
		
		System.out.println(salBreakup);
		

	}

}
