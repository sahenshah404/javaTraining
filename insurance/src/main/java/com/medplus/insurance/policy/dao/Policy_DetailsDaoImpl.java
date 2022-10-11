package com.medplus.insurance.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medplus.insurance.policy.beans.Policy_Details;
import com.medplus.insurance.policy.utils.DBConnection;
import com.medplus.insurance.policy.utils.DBQuery;

public class Policy_DetailsDaoImpl implements Policy_DetailsDao{

	Connection conn;
	PreparedStatement pst;
	
	
	@Override
	public int createPolicyDetail(Policy_Details policy_Detail) {
		int result = 0;
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.CREATEPOLICYDETAILS);
			pst.setLong(1, policy_Detail.getPolicy_number());
			pst.setString(2, policy_Detail.getQuestion_id());
			pst.setString(3, policy_Detail.getAnswer());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		return result;
	}

}
