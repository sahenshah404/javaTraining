package com.medplus.employee.main;

import java.util.List;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class GetEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService service  = new EmployeeServiceImpl();
		List<Employee> empList;
		empList =  service.getEmployees();
		
		empList.forEach((emp)->{
			System.out.println(emp);
		});
	}

}
