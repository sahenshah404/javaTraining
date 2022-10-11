package com.medplus.employee.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.employee.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	@Query(value = "select emp from Employee emp where emp.doj = ?1")
	List<Employee> getEmployeesByDoj(Date date);

	@Query(value = "select emp from Employee emp where emp.job = ?1")
	List<Employee> getEmployeesByjob(String job);
}
