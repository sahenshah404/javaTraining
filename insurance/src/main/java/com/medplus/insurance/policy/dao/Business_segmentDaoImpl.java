package com.medplus.insurance.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.Business_Segment;
import com.medplus.insurance.policy.utils.DBConnection;
import com.medplus.insurance.policy.utils.DBQuery;

public class Business_segmentDaoImpl implements Business_SegmentDao{
	 Connection conn;
	 PreparedStatement pst;
	 
	@Override
	public List<Business_Segment> getAllBusSeg() {
		List<Business_Segment> business_Segments = new ArrayList<Business_Segment>();
		try {
			conn = DBConnection.connect();
			pst = conn.prepareStatement(DBQuery.GETALLBUSSEG);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Business_Segment bsg = new Business_Segment();
				bsg.setBus_seg_id(rs.getString(1));
				bsg.setBus_seg_seq(rs.getInt(2));
				bsg.setBus_seg_name(rs.getString(3));
				business_Segments.add(bsg);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnection.close();
		}
		return business_Segments;
		
	}

}
