package com.medplus.employee.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.entities.Employee;

@SpringBootTest
public class EmployeeDaoTest {
	@Autowired
	EmployeeDao dao;
	
	@Test
	public void testFindByIdTrue() {
		Optional<Employee> employee = dao.findById(101);
		assertTrue(employee.isPresent());
	}
	
	@Test
	public void testFindByIdFalse() {
		Optional<Employee> employee = dao.findById(111);
		assertFalse(employee.isPresent());
	}
	
	@Test
	public void getAll() {
		 List<Employee> employees = dao.findAll();
		 assertFalse(employees.size()==0);
	}
	
}
