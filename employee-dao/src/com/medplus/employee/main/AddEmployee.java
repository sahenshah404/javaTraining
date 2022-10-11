package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.beans.Department;
import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class AddEmployee {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService service = new EmployeeServiceImpl();
		DepartmentService deptService = new DepartmentServiceImpl();
		boolean counter = true;
		while (counter) {
			int code = 0;
			code = service.getEmpCode();
			if (code == 0) {
				System.out.println("Enter employee code");
				code = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Enter Employee name");
			String name = sc.nextLine();

			System.out.println("Enter Employee Job");
			String job = sc.nextLine();

			System.out.println("Enter Employee Salary");
			int salary = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Employee doj in dd-MM-yyyy format");
			String doj = sc.nextLine();

			System.out.println("Enter your department");
			String deptname = sc.nextLine();

			Department department = deptService.getDepartmentByName(deptname);
			if (department != null) {
				int deptno = department.getDeptno();
				Employee emp = new Employee(code, name, job, doj, salary, deptno);
				int rows = service.addEmployee(emp);
				if (rows > 0) {
					System.out.println("Employee recored Created");
					System.out.println("Your Emp Code is : "+ code);
				} else {
					System.out.println("Not Inserted");
				}
			} else {
				System.out.println("Employee record would not be created");
			}
			System.out.println("Do you want to add more employee y/n");
			String s = sc.nextLine();
			if (!s.equalsIgnoreCase("y")) {
				counter = false;
			}
//		counter = false;
		}
	}

}
