package com.medplus.employee.utils;

public class EmployeeDBQueries {
	public static final String ADDEMPL = 
			"insert into employee values(?,?,?,?,?,?)";
	public static final String GETEMPLS = 
			"select * from employee";
	public static final String GETEMPBYCODE = 
			"select * from employee where code = ?";
	public static final String DELEMPBYCODE = 
			"delete from employee where code = ?";
	public static final String UPDATEEMPNAMEBYCODE = 
			"update employee set name = ? where code = ?";
	public static final String UPDATEEMPJOBBYCODE = 
			"update employee set job = ? where code = ?";
	public static final String UPDATEEMPSALBYCODE = 
			"update employee set salary = ? where code = ?";
	public static final String GETMAXEMPCODE = 
			"select max(code) maxcode from employee";
	
	
	public static final String REMOVEEMPFROMDEPTBYDEPTNO = 
			"update employee set deptno = null where deptno = ?";
	public static final String REMOVEEMPFROMDEPTBYNAME = 
			"update employee set deptno = null where deptno = "
					+ "(select deptno from department where deptname = ?)";
	
	
	
	public static final String GETDEPTS = 
			"select * from department";
	public static final String ADDDEPT = 
			"insert into department values(?,?,?,?)";
	public static final String UPDATEDEPTLOCATION = 
			"update department set location = ?, remarks = ? where deptno = ?";
	public static final String GETDEPTBYDEPTNO = 
			"select * from department where deptno = ?";
	public static final String GETDEPTBYNAME = 
			"select * from department where deptname = ?";
	public static final String DELDEPTBYNAME = 
			"update department set remarks = 'department closed' where deptname = ?";
	public static final String DELDEPTBYDEPTNO = 
			"update department set remarks = 'department closed' where deptno = ?";
	public static final String CHECKIFDEPTEXISTS = 
			"select * from department where deptno = ? or deptname = ?";
	public static final String GETMAXDEPTCODE = 
			"select max(deptno) maxcode from department";
	
}
