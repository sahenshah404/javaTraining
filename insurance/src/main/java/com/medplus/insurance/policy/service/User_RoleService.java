package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.User_Role;

public interface User_RoleService {
	User_Role findByUser_name(String user_names);
	String Login(String user_name , String password);
	String checkIfAccountCreated(String username);
	String createUser(String username, String password, String role);
	List<User_Role> getAllAgents();
	List<User_Role> getAllInsureds();
}
