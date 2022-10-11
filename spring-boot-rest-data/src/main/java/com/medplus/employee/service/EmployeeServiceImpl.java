package com.medplus.employee.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.employee.dao.DepartmentDao;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dto.EmployeeDTO;
import com.medplus.employee.entities.Department;
import com.medplus.employee.entities.Employee;
import com.medplus.employee.exceptions.DepartmentNotFoundException;
import com.medplus.employee.exceptions.EmployeeExistException;
import com.medplus.employee.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public void addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = convertEmployeeDTOtoEmployee(employeeDTO);
		if (employeeDao.findById(employeeDTO.getEmpCode()) == null) {
			throw new EmployeeExistException();
		}
		employeeDao.save(employee);
	}

	private Employee convertEmployeeDTOtoEmployee(EmployeeDTO employeeDTO) {
		Department dept = departmentDao.getDeptByName(employeeDTO.getDeptName());
		if (dept == null) {
			throw new DepartmentNotFoundException();
		}
		Employee employee = new Employee();
		employee.setDoj(employeeDTO.getDoj());
		employee.setEmpCode(employeeDTO.getEmpCode());
		employee.setEmpname(employeeDTO.getEmpName());
		employee.setJob(employeeDTO.getJob());
		employee.setSalary(employeeDTO.getSalary());
		employee.setDepartment(dept);
		return employee;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> empList = employeeDao.findAll();
		return (List<EmployeeDTO>) empList.stream().map(this::convertEmployeeToEmployeeDTO)
				.collect(Collectors.toList());
	}

	public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setDeptName(employee.getDepartment().getDeptName());
		employeeDTO.setEmpCode(employee.getEmpCode());
		employeeDTO.setDoj(employee.getDoj());
		employeeDTO.setEmpName(employee.getEmpname());
		employeeDTO.setJob(employee.getJob());
		employeeDTO.setSalary(employee.getSalary());
		return employeeDTO;
	}

	@Override
	public EmployeeDTO getEmployeeByCode(int code) {
		Optional<Employee> emp = employeeDao.findById(code);
		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		EmployeeDTO empdto = convertEmployeeToEmployeeDTO(emp.get());
		return empdto;
	}

	@Override
	public void deleteEmployee(int code) {
		Optional<Employee> emp = employeeDao.findById(code);
		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		employeeDao.deleteById(code);
	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		Optional<Employee> emp = employeeDao.findById(employeeDTO.getEmpCode());
		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		Employee employee = convertEmployeeDTOtoEmployee(employeeDTO);
		employeeDao.save(employee);
	}

	@Override
	public List<EmployeeDTO> getEmployeesByDoj(Date date) {
		List<Employee> emplist = employeeDao.getEmployeesByDoj(date);
		return emplist.stream().map(this::convertEmployeeToEmployeeDTO).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> getEmployeesByJob(String job) {
		List<Employee> emplist = employeeDao.getEmployeesByjob(job);
		return emplist.stream().map(this::convertEmployeeToEmployeeDTO).collect(Collectors.toList());
	}

}
