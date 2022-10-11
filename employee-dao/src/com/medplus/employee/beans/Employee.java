package com.medplus.employee.beans;

public class Employee {
	private int empcode;
	private String empname;
	private String job;
	private String doj;
	private double salary;
	private int deptno;
	
	public Employee() {
		
	}

	public Employee(int empcode, String empname, String job, String doj, double salary, int deptno) {
		super();
		this.empcode = empcode;
		this.empname = empname;
		this.job = job;
		this.doj = doj;
		this.salary = salary;
		this.deptno = deptno;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [empcode=" + empcode + ", empname=" + empname + ", job=" + job + ", doj=" + doj + ", salary="
				+ salary + ", deptno=" + deptno + "]";
	}

	public int getEmpcode() {
		return empcode;
	}

	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
