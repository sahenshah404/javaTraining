package com.medplus.insurance.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.User_Role;
import com.medplus.insurance.policy.utils.DBConnection;
import com.medplus.insurance.policy.utils.DBQuery;

public class User_RoleDaoImpl implements User_RoleDao {
	Connection conn;
	PreparedStatement pst;

	@Override
	public User_Role findByUsername(String username) {
		User_Role user = null;
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.FINDBYUSER_NAME);
			pst.setString(1, username);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				user = new User_Role();
				user.setUser_name(rst.getString(1));
				user.setPassword(rst.getString(2));
				user.setRole_code(rst.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}

		return user;
	}

	@Override
	public Integer createUser(String username, String password, String role) {
		int queryResult = 0;
		try {
		conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.CREATEUSER);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, role);
			queryResult =  pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return queryResult;
	}

	@Override
	public List<User_Role> getAllAgents() {
		List<User_Role> agents = new ArrayList<User_Role>();
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETALLAGENTS);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User_Role user = new User_Role();
				user.setUser_name(rs.getString(1));
				user.setRole_code(rs.getString(2));
				agents.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		return agents;
	}

	@Override
	public List<User_Role> getAllInsureds() {
		List<User_Role> insureds = new ArrayList<User_Role>();
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETALLINSUREDS);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User_Role user = new User_Role();
				user.setUser_name(rs.getString(1));
				user.setRole_code(rs.getString(2));
				insureds.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		return insureds;
	}

}
