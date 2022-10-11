package com.medplus.employee.service;

import java.util.Date;
import java.util.List;

import com.medplus.employee.dto.EmployeeDTO;

public interface EmployeeService {
	void addEmployee(EmployeeDTO employeeDTO);

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployeeByCode(int code);

	void deleteEmployee(int code);

	void updateEmployee(EmployeeDTO employeeDTO);

	List<EmployeeDTO> getEmployeesByDoj(Date date);

	List<EmployeeDTO> getEmployeesByJob(String job);
}
