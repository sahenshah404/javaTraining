package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class DeleteDepartmentByDeptNo {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		DepartmentService service = new DepartmentServiceImpl();
		System.out.println("Enter the department number");
		int deptno = sc.nextInt();
		int rows = service.deleteDepartmentByDeptNo(deptno);
		if(rows > 0) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Not deleted");
		}
	}
}
