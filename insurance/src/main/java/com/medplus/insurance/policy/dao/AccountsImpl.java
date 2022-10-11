package com.medplus.insurance.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.Accounts;
import com.medplus.insurance.policy.utils.DBConnection;
import com.medplus.insurance.policy.utils.DBQuery;

public class AccountsImpl implements AccountsDao{
	Connection conn;
	PreparedStatement pst;

	@Override
	public Accounts findAccountByUsername(String username) {
		Accounts account = null;
		
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.FINDACCOUNTBYUSERNAME);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				account = new Accounts();
				account.setAccount_number(rs.getLong(1));
				account.setInsured_name(rs.getString(2));
				account.setInsured_street(rs.getString(3));
				account.setInsured_city(rs.getString(4));
				account.setInsured_state(rs.getString(5));
				account.setInsured_zip(rs.getInt(6));
				account.setBusiness_segment(rs.getString(7));
				account.setUser_name(rs.getString(8));
				account.setAgent(rs.getString(9));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		
		return account;
	}

	@Override
	public long getMaxAccountNumber() {
		long maxAccNo=0;
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETMAXACCOUNTNUMBER);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				maxAccNo = rs.getLong(1);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		return maxAccNo;
	}

	@Override
	public int createAccount(Accounts account) {
		int queryResult = 0;
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.CREATEACCOUNT);
			pst.setLong(1, account.getAccount_number());
			pst.setString(2, account.getInsured_name());
			pst.setString(3, account.getInsured_street());
			pst.setString(4, account.getInsured_city());
			pst.setString(5, account.getInsured_state());
			pst.setInt(6, account.getInsured_zip());
			pst.setString(7, account.getBusiness_segment());
			pst.setString(8, account.getUser_name());
			pst.setString(9, account.getAgent());
			queryResult = pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		return queryResult;
	}

	@Override
	public List<Accounts> getAllAccounts() {
		List<Accounts> accounts = new ArrayList<Accounts>();
		
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETALLACCOUNTS);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Accounts account = new Accounts();
				account.setAccount_number(rs.getLong(1));
				account.setInsured_name(rs.getString(2));
				account.setBusiness_segment(rs.getString(3));
				account.setUser_name(rs.getString(4));
				accounts.add(account);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		
		return accounts;
	}

	@Override
	public List<Accounts> getInsuredForAgent(String agentId) {
List<Accounts> accounts = new ArrayList<Accounts>();
		
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETINSUREDFORAGENT);
			pst.setString(1, agentId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Accounts account = new Accounts();
				account.setAccount_number(rs.getLong(1));
				account.setInsured_name(rs.getString(2));
				account.setBusiness_segment(rs.getString(3));
				account.setUser_name(rs.getString(4));
				accounts.add(account);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		
		return accounts;
	}

}
