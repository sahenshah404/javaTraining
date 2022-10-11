package com.medplus.employee.dao;

import java.util.List;

import com.medplus.employee.beans.Employee;

public interface EmployeeDao {
	int addEmployee (Employee employee);
	List<Employee> getEmployees();
	Employee getEmployeeByCode(int empcode);
	int deleteEmployeeByCode (int empcode);
	int updateEmpNameByCode(int empcode, String newValue);
	int updateEmpJobByCode(int empcode, String newValue);
	int updateEmpSalaryByCode(int empcode, Double newValue);
//	int updateEmpDeptByCode(int empcode, int newValue);
	
	int maxEmpCode();
	int removeEmpFromDepartmentByName(String name);
	int removeEmpFromDepartmentByDeptNo(int deptno);
}
