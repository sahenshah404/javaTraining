package com.medplus.insurance.policy.dao;

import java.util.List;

import com.medplus.insurance.policy.beans.User_Role;

public interface User_RoleDao {
	User_Role findByUsername(String username);
	Integer createUser(String username, String password, String role);
	List<User_Role> getAllAgents();
	List<User_Role> getAllInsureds();
}
