package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class GetDepartmentByDeptNo {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentService service = new DepartmentServiceImpl();
		System.out.println("Enter the department number");
		 int deptno = sc.nextInt();
		 
		Department department = service.getDepartmentByDeptNo(deptno);
		
		if(department != null)
			System.out.println(department);

	}

}
