package com.medplus.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.EmployeeDaoImpl;
import com.medplus.employee.exception.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public int addEmployee(Employee employee) {
		int rows = dao.addEmployee(employee);
		return rows;
	}

	@Override
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	@Override
	public Employee getEmployeeByCode(int empcode) {
		Employee employee = dao.getEmployeeByCode(empcode);
		try {
			if (employee == null) {
				throw new EmployeeNotFoundException();
			}

		} catch (EmployeeNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return employee;
	}

	@Override
	public int deleteEmployeeByCode(int empcode) {
		return dao.deleteEmployeeByCode(empcode);
	}

	@Override
	public int updateEmpNameByCode(int empcode, String newValue) {
		// TODO Auto-generated method stub
		return dao.updateEmpNameByCode(empcode, newValue);
	}

	@Override
	public int updateEmpJobByCode(int empcode, String newValue) {
		// TODO Auto-generated method stub
		return dao.updateEmpJobByCode(empcode, newValue);
	}

	@Override
	public int updateEmpSalaryByCode(int empcode, Double newValue) {
		// TODO Auto-generated method stub
		return dao.updateEmpSalaryByCode(empcode, newValue);
	}

	@Override
	public int getEmpCode() {
		int maxcode = dao.maxEmpCode();
		if (maxcode != 0)
			return ++maxcode;
		else {
			return 0;
		}
	}

	@Override
	public int removeEmpFromDepartmentByName(String name) {
		return dao.removeEmpFromDepartmentByName(name);
	}

	@Override
	public int removeEmpFromDepartmentByDeptNo(int deptno) {
		return dao.removeEmpFromDepartmentByDeptNo(deptno);
	}

	@Override
	public Map<String, Double> calculateNetPay(int empcode) {
		Employee employee = dao.getEmployeeByCode(empcode);
		Map<String, Double> salBreakup = null;
		if (employee != null) {
			Double salary = employee.getSalary();
			salBreakup = new HashMap<String, Double>();
			salBreakup.put("BASIC", salary*0.51);
			salBreakup.put("HRA", salary*0.3);
			salBreakup.put("GMIP", salary*0.05);
			salBreakup.put("GRATUITY", salary*0.04);
			salBreakup.put("P-TAX", salary*0.1);
			salBreakup.put("NET_PAY", salary-salary*0.1);
			salBreakup.put("GROSS_SALARY", salary);

		}
		return salBreakup;
	}

}
