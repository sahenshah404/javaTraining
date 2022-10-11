package com.medplus.employee.main;

import java.util.Scanner;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class ShiftLocation {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentService service = new DepartmentServiceImpl();
		System.out.println("Enter the Department no");
		int deptno = sc.nextInt();
		sc.nextLine();

		Department department = service.getDepartmentByDeptNo(deptno);
		if (department != null) {

			System.out.println("Enter the department new Location");
			String newLocation = sc.nextLine();

			System.out.println("Enter Remarks*");
			String newRemarks = sc.nextLine();
			while (newRemarks.length() < 1) {
				System.out.println("Please Enter Remarks");
				newRemarks = sc.nextLine();
			}

			int row = service.shiftLocation(deptno, newLocation, newRemarks);
			if (row > 0) {
				System.out.println("Location updated");
			} else {
				System.out.println("Not updated");
			}
		}

	}

}
