package com.medplus.employee.service;

import java.util.List;
import java.util.Optional;

import com.medplus.employee.entities.Department;

public interface DepartmentService {
	List<Department> getAllDepartments();

	void addDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(int deptNo);

	Optional<Department> getDepartmentByDeptNo(int deptNo);

}
