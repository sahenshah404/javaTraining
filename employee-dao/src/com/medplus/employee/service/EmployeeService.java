package com.medplus.employee.service;

import java.util.List;
import java.util.Map;

import com.medplus.employee.beans.Employee;

public interface EmployeeService {
	int addEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployeeByCode(int empcode);

	int deleteEmployeeByCode(int empcode);

	int updateEmpNameByCode(int empcode, String newValue);

	int updateEmpJobByCode(int empcode, String newValue);

	int updateEmpSalaryByCode(int empcode, Double newValue);

	int getEmpCode();

	int removeEmpFromDepartmentByName(String name);

	int removeEmpFromDepartmentByDeptNo(int deptno);
	
	Map<String, Double> calculateNetPay(int empcode);
}
