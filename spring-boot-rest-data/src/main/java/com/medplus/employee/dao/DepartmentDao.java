package com.medplus.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.employee.entities.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
	@Query(value = "select dept from Department dept where deptName = ?1")
	Department getDeptByName(String string);
}
