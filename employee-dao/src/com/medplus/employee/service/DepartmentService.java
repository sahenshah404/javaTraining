package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Department;

public interface DepartmentService {
	
	List<Department> getAllDept();
	int addDepartment(Department department);
	int shiftLocation(int deptno, String newLocation, String newRemarks);
	Department getDepartmentByDeptNo(int deptno);
	Department getDepartmentByName(String deptname);
	int deleteDepartmentByName(String deptname);
	int deleteDepartmentByDeptNo(int deptno);

	boolean checkIfDepartmentExists(int deptno,String deptname);
	int getDeptCode();
	
}
