package com.medplus.insurance.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.Policy_Questions;
import com.medplus.insurance.policy.utils.DBConnection;
import com.medplus.insurance.policy.utils.DBQuery;

public class Policy_QuestionsDaoImpl implements Policy_QuestionsDao{

	Connection conn;
	PreparedStatement pst;
	
	@Override
	public List<Policy_Questions> getPolicyQues(String busSegId) {
		List<Policy_Questions> policy_Questions = new ArrayList<Policy_Questions>();
		
		try {
		conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETPOLICYQUESFORBUSSEG);
			pst.setString(1, busSegId);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Policy_Questions policy_Question = new Policy_Questions();
				policy_Question.setPol_ques_id(rs.getString(1));
				policy_Question.setPol_ques_seq(rs.getInt(2));
				policy_Question.setBus_seg_id(rs.getString(3));
				policy_Question.setPol_ques_desc(rs.getString(4));
				policy_Question.setPol_ques_ans1(rs.getString(5));
				policy_Question.setPol_ques_ans1_weightage(rs.getInt(6));
				policy_Question.setPol_ques_ans2(rs.getString(7));
				policy_Question.setPol_ques_ans2_weightage(rs.getInt(8));
				policy_Question.setPol_ques_ans3(rs.getString(9));
				policy_Question.setPol_ques_ans3_weightage(rs.getInt(10));
				policy_Questions.add(policy_Question);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		
		return policy_Questions;
	}

}
