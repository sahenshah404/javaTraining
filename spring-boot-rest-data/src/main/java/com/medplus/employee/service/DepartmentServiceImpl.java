package com.medplus.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.employee.dao.DepartmentDao;
import com.medplus.employee.entities.Department;
import com.medplus.employee.exceptions.DepartmentExistException;
import com.medplus.employee.exceptions.DepartmentNotFoundException;
import com.medplus.employee.exceptions.EmptyDepartmentException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments() {
		List<Department> deptList = departmentDao.findAll();
		if (deptList.isEmpty()) {
			throw new EmptyDepartmentException();
		}
		return deptList;
	}

	@Override
	public void addDepartment(Department department) {
		if (departmentDao.findById(department.getDeptNo()) == null) {
			throw new DepartmentExistException();
		}
		departmentDao.save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.save(department);
	}

	@Override
	public void deleteDepartment(int deptNo) {
		if (departmentDao.findById(deptNo) == null) {
			throw new DepartmentNotFoundException();
		}
		departmentDao.deleteById(deptNo);
	}

	@Override
	public Optional<Department> getDepartmentByDeptNo(int deptNo) {
		if (departmentDao.findById(deptNo) == null) {
			throw new DepartmentNotFoundException();
		}
		return departmentDao.findById(deptNo);
	}

}
