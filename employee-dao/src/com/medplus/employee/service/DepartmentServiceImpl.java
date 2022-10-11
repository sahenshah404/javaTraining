package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Department;
import com.medplus.employee.dao.DepartmentDao;
import com.medplus.employee.dao.DepartmentDaoImpl;
import com.medplus.employee.exception.DepartmentClosedException;
import com.medplus.employee.exception.DepartmentNotFoundException;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao deptDao = new DepartmentDaoImpl();
	EmployeeService empService = new EmployeeServiceImpl();

	@Override
	public List<Department> getAllDept() {
		return deptDao.getAllDept();
	}

	@Override
	public int addDepartment(Department department) {
		return deptDao.addDepartment(department);
	}

	@Override
	public int shiftLocation(int deptno, String newLocation, String remarks) {
		return deptDao.shiftLocation(deptno, newLocation, remarks);
	}

	@Override
	public Department getDepartmentByDeptNo(int deptno) {
		Department department = deptDao.getDepartmentByDeptNo(deptno);
		try {
			if (department == null) {
				throw new DepartmentNotFoundException();
			}
			else if (department.getRemarks().equalsIgnoreCase("department closed")) {
				department = null;
				throw new DepartmentClosedException();
			}

		} catch (DepartmentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (DepartmentClosedException e) {
			System.out.println(e.getMessage());
		}
		return department;
	}

	@Override
	public Department getDepartmentByName(String deptname) {
		Department department = deptDao.getDepartmentByName(deptname);
		try {
			if (department == null) {
				throw new DepartmentNotFoundException();
			}
			else if (department.getRemarks().equalsIgnoreCase("department closed")) {
				department = null;
				throw new DepartmentClosedException();
			}

		} catch (DepartmentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (DepartmentClosedException e) {
			System.out.println(e.getMessage());
		}
		return department;
	}

	@Override
	public int deleteDepartmentByName(String deptname) {
		empService.removeEmpFromDepartmentByName(deptname);
		return deptDao.deleteDepartmentByName(deptname);
	}

	@Override
	public int deleteDepartmentByDeptNo(int deptno) {
		empService.removeEmpFromDepartmentByDeptNo(deptno);
		return deptDao.deleteDepartmentByDeptNo(deptno);
	}

	@Override
	public boolean checkIfDepartmentExists(int deptno, String deptname) {
		Department department = deptDao.checkIfDepartmentExists(deptno, deptname);
		if(department == null)
			return true;
		else {
			return false;
		}
	}

	@Override
	public int getDeptCode() {
		int maxcode = deptDao.maxDeptCode();
		if(maxcode!=0 )
			return ++maxcode;
		else {
			return 0 ;
		}
	}

}
