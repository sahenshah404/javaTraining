package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class DeleteDepartmentByName {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		DepartmentService service = new DepartmentServiceImpl();
		System.out.println("Enter the department name");
		String deptname = sc.nextLine();
		int rows = service.deleteDepartmentByName(deptname);
		if(rows > 0) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Not deleted");
		}
	}

}
