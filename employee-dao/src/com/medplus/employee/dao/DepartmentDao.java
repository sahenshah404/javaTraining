package com.medplus.employee.dao;

import java.util.List;

import com.medplus.employee.beans.Department;

public interface DepartmentDao {

	List<Department> getAllDept();
	int addDepartment(Department department);
	int shiftLocation(int deptno, String newLocation, String remarks);
	Department getDepartmentByDeptNo(int deptno);
	Department getDepartmentByName(String deptname);
	int deleteDepartmentByName(String deptname);
	int deleteDepartmentByDeptNo(int deptno);
	
	Department checkIfDepartmentExists(int deptno,String deptname);
	int maxDeptCode();
	
	
}

