package com.medplus.insurance.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.Policy;
import com.medplus.insurance.policy.utils.DBConnection;
import com.medplus.insurance.policy.utils.DBQuery;

public class PolicyDaoImpl implements PolicyDao {

	Connection conn;
	PreparedStatement pst;

	@Override
	public int getMaxpolicyNumber() {
		int maxPolNo = 0;
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETMAXPOLICYNUMBER);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				maxPolNo = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.close();
		}
		return maxPolNo;
	}

	@Override
	public int createPolicy(Policy policy) {
		int result = 0;
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.CREATEPOLICY);
			pst.setInt(1, policy.getPolicy_number());
			pst.setDouble(2, policy.getPolicy_premium());
			pst.setLong(3, policy.getAccount_number());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.close();
		}
		return result;
	}

	@Override
	public List<Policy> getAllPolicy() {
		List<Policy> policies = new ArrayList<Policy>();

		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETALLPOLICY);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				policy.setPolicy_number(rs.getInt(1));
				policy.setPolicy_premium(rs.getDouble(2));
				policy.setAccount_number(rs.getInt(3));
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return policies;
	}

	@Override
	public List<Policy> getPolicyForAgent(String username) {
		List<Policy> policies = new ArrayList<Policy>();

		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETPOLICYFORAGENT);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				policy.setPolicy_number(rs.getInt(1));
				policy.setPolicy_premium(rs.getDouble(2));
				policy.setAccount_number(rs.getInt(3));
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return policies;
	}

	@Override
	public List<Policy> getPolicyByAccountNum(long account_number) {
		List<Policy> policies = new ArrayList<Policy>();

		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETPOLICYFORACCOUNT);
			pst.setLong(1, account_number);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				policy.setPolicy_number(rs.getInt(1));
				policy.setPolicy_premium(rs.getDouble(2));
				policy.setAccount_number(rs.getInt(3));
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return policies;
	}

}
