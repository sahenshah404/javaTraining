package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.Accounts;
import com.medplus.insurance.policy.beans.User_Role;
import com.medplus.insurance.policy.dao.User_RoleDao;
import com.medplus.insurance.policy.dao.User_RoleDaoImpl;

public class User_RoleServiceImpl implements User_RoleService{
	User_RoleDao user_role = new User_RoleDaoImpl();
	AccountsService accountsService = new AccountsServiceImpl();
	
	@Override
	public User_Role findByUser_name(String user_name) {
		User_Role user = user_role.findByUsername(user_name);
			return user;
	}

	@Override
	public String Login(String user_name, String password) {
		User_Role user = findByUser_name(user_name);
		String role = null;
		if(user!=null) {
			if(!user.getPassword().equals(password)) {
				user = null;
			}
			else {
				role= user.getRole_code();
			}
		}
		return role;
	}

	@Override
	public String checkIfAccountCreated(String username) {
		Accounts account = accountsService.findAccountByUsername(username);
		if(account!=null) {
			return "created";
		}
		else {
			return "not created";
		}
		
	}

	@Override
	public String createUser(String username, String password, String role) {
		User_Role user = user_role.findByUsername(username);
		if(user==null) {
			int result = user_role.createUser(username, password, role);
			if(result>0) {				
				return "user created";
			}else {
				return "user cannot be created, error while inserting";
			}
		}else {
			return "username already present";
		}
		
	}

	@Override
	public List<User_Role> getAllAgents() {
		List<User_Role> agents = user_role.getAllAgents();
		return agents;
	}

	@Override
	public List<User_Role> getAllInsureds() {
		List<User_Role> insureds = user_role.getAllInsureds();
		return insureds;
	}

}
