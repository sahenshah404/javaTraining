package com.medplus.employee.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.EmployeeDaoImpl;

class employeeDaoTest {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Test
	public void testEmployeeDao() {
		Employee employee = new Employee(111, "sai", "admin","01-01-2001",50000, 1002);
		assertEquals(1, employeeDao.addEmployee(employee));
	}

}
