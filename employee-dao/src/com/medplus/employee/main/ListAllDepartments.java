package com.medplus.employee.main;

import java.util.List;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class ListAllDepartments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DepartmentService service =new  DepartmentServiceImpl();
		
		List<Department> departments = service.getAllDept();
		
		departments.forEach((department)->{
			System.out.println(department);
		});
		
	}

}
