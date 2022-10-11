package com.medplus.insurance.policy.beans;

public class User_Role {
 private String user_name;
 private String password;
 private String role_code;
 
 public User_Role() {
	// TODO Auto-generated constructor stub
}

public User_Role(String user_name, String password, String role_code) {
	super();
	this.user_name = user_name;
	this.password = password;
	this.role_code = role_code;
}

public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole_code() {
	return role_code;
}

public void setRole_code(String role_code) {
	this.role_code = role_code;
}

@Override
public String toString() {
	return "User_Role [user_name=" + user_name + ", password=" + password + ", role_code=" + role_code + "]";
}
 
 
 
}
