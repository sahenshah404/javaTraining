package com.medplus.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employee.beans.Department;
import com.medplus.employee.utils.DBConnection;
import com.medplus.employee.utils.EmployeeDBQueries;

public class DepartmentDaoImpl implements DepartmentDao{
	Connection conn;
	PreparedStatement pst;

	@Override
	public int addDepartment(Department department) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.ADDDEPT);
			pst.setInt(1, department.getDeptno());
			pst.setString(2, department.getDeptname());
			pst.setString(3, department.getLocation());
			pst.setString(4, department.getRemarks());
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public int shiftLocation(int deptno,String newLocation, String remarks) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.UPDATEDEPTLOCATION);
			pst.setString(1, newLocation);
			pst.setString(2, remarks);
			pst.setInt(3, deptno);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}

		return rows;
	}

	@Override
	public List<Department> getAllDept() {
		conn = DBConnection.open();
		List<Department> departments = new ArrayList<Department>();
		

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETDEPTS);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				department.setDeptno(rs.getInt(1));
				department.setDeptname(rs.getString(2));
				department.setLocation(rs.getString(3));
				department.setRemarks(rs.getString(4));
				departments.add(department);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}

		return departments;
	}

	@Override
	public Department getDepartmentByDeptNo(int deptno) {
//		Department department = new Department();
		Department department = null;
		conn = DBConnection.open();
		
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETDEPTBYDEPTNO);
			pst.setInt(1, deptno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				department = new Department();
				department.setDeptno(rs.getInt(1));
				department.setDeptname(rs.getString(2));
				department.setLocation(rs.getString(3));
				department.setRemarks(rs.getString(4));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}
		
		return department;
		
	}

	@Override
	public Department getDepartmentByName(String deptname) {
//		Department department = new Department();
		Department department = null;
		conn = DBConnection.open();
		
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETDEPTBYNAME);
			pst.setString(1, deptname);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				department = new Department();
				department.setDeptno(rs.getInt(1));
				department.setDeptname(rs.getString(2));
				department.setLocation(rs.getString(3));
				department.setRemarks(rs.getString(4));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}
		
		return department;
	}

	@Override
	public int deleteDepartmentByName(String deptname) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.DELDEPTBYNAME);
			pst.setString(1, deptname);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}

		return rows;
	}

	@Override
	public int deleteDepartmentByDeptNo(int deptno) {
		conn = DBConnection.open();
		int rows = 0;

		try {
			pst = conn.prepareStatement(EmployeeDBQueries.DELDEPTBYDEPTNO);
			pst.setInt(1, deptno);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}

		return rows;
	}

	@Override
	public Department checkIfDepartmentExists(int deptno, String deptname) {
//		Department department = new Department();
		Department department = null;
		conn = DBConnection.open();
		
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.CHECKIFDEPTEXISTS);
			pst.setInt(1, deptno);
			pst.setString(2, deptname);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				department =  new Department();
				department.setDeptno(rs.getInt(1));
				department.setDeptname(rs.getString(2));
				department.setLocation(rs.getString(3));
				department.setRemarks(rs.getString(4));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBConnection.close();
		}
		
		return department;
	}

	@Override
	public int maxDeptCode() {
		conn = DBConnection.open();
		int maxcode = 0;
		try {
			pst = conn.prepareStatement(EmployeeDBQueries.GETMAXDEPTCODE);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				maxcode = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return maxcode;
	}


}
