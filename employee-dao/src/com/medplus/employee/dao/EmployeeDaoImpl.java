package com.medplus.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.utils.DBConnection;
import com.medplus.employee.utils.DateParsing;
import com.medplus.employee.utils.EmployeeDBQueries;

public class EmployeeDaoImpl implements EmployeeDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public int addEmployee(Employee employee) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.ADDEMPL);
			pst.setInt(1, employee.getEmpcode());
			pst.setString(2, employee.getEmpname());
			pst.setString(3, employee.getJob());
			pst.setDouble(4, employee.getSalary());
			pst.setDate(5, DateParsing.getSqlDate(employee.getDoj()));
			pst.setInt(6, employee.getDeptno());
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public List<Employee> getEmployees() {
		conn = DBConnection.open();
		List<Employee> empList = new ArrayList<Employee>();
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETEMPLS);
			rs = pst.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setDoj(rs.getDate(5).toString());
				emp.setDeptno(rs.getInt(6));
				empList.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return empList;

	}

	@Override
	public Employee getEmployeeByCode(int empcode) {
		Employee emp = null;
		conn = DBConnection.open();
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETEMPBYCODE);
			pst.setInt(1, empcode);
			rs = pst.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setDoj(rs.getDate(5).toString());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return emp;
	}

	@Override
	public int deleteEmployeeByCode(int empcode) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.DELEMPBYCODE);
			pst.setInt(1, empcode);
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public int updateEmpNameByCode(int empcode, String newValue) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.UPDATEEMPNAMEBYCODE);
			pst.setString(1, newValue);
			pst.setInt(2, empcode);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}

		return rows;
	}

	@Override
	public int updateEmpSalaryByCode(int empcode, Double newValue) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.UPDATEEMPSALBYCODE);
			pst.setDouble(1, newValue);
			pst.setInt(2, empcode);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}

		return rows;
	}

	@Override
	public int updateEmpJobByCode(int empcode, String newValue) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.UPDATEEMPJOBBYCODE);
			pst.setString(1, newValue);
			pst.setInt(2, empcode);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}

		return rows;
	}
	
	
//	@Override
//	public int updateEmpDeptByCode(int empcode, int newValue) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	

	@Override
	public int maxEmpCode() {
		conn = DBConnection.open();
		int maxcode = 0;
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETMAXEMPCODE);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				maxcode = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return maxcode;
	}

	@Override
	public int removeEmpFromDepartmentByName(String name) {
		conn = DBConnection.open();
		int rows = 0;
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.REMOVEEMPFROMDEPTBYNAME);
			pst.setString(1, name);
			rows = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public int removeEmpFromDepartmentByDeptNo(int deptno) {
		conn = DBConnection.open();
		int rows = 0;
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.REMOVEEMPFROMDEPTBYDEPTNO);
			pst.setInt(1, deptno);
			rows = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return rows;
	}

	

}
