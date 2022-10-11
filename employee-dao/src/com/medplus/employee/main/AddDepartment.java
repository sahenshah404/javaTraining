package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.beans.Department;
import com.medplus.employee.exception.DepartmentAlreadyExistsExceptiion;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class AddDepartment {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		DepartmentService service = new DepartmentServiceImpl();

		boolean counter = true;
		while (counter) {
			int deptno = service.getDeptCode();
			if (deptno == 0) {
				System.out.println("Enter Department number");
				deptno = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Enter Department name");
			String deptname = sc.nextLine();

			System.out.println("Enter Deprtment Location");
			String location = sc.nextLine();

			System.out.println("Enter Remarks");
			String remarks = sc.nextLine();

			try {
				if (service.checkIfDepartmentExists(deptno, deptname)) {

					Department department = new Department(deptno, deptname, location, remarks);

					int rows = service.addDepartment(department);

					if (rows > 0) {
						System.out.println("New Departmemt created with deptno: " + deptno);
					} else {
						System.out.println("Not Inserted");
					}
				} else {
					throw new DepartmentAlreadyExistsExceptiion();
				}
			} catch (DepartmentAlreadyExistsExceptiion e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to add more Department y/n");
			String s = sc.nextLine();
			if (!s.equalsIgnoreCase("y")) {
				counter = false;
			}
		}

	}

}
