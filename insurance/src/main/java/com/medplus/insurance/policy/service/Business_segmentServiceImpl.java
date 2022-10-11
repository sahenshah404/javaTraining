package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.Business_Segment;
import com.medplus.insurance.policy.dao.Business_SegmentDao;
import com.medplus.insurance.policy.dao.Business_segmentDaoImpl;

public class Business_segmentServiceImpl  implements Business_segmentService{
	
	Business_SegmentDao business_SegmentDao = new Business_segmentDaoImpl();

	@Override
	public List<Business_Segment> getAllBusSeg() {
		List<Business_Segment> business_Segments = business_SegmentDao.getAllBusSeg();
		return business_Segments;
	}

}
