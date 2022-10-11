package com.medplus.insurance.policy.service;

import com.medplus.insurance.policy.beans.Policy_Details;
import com.medplus.insurance.policy.dao.Policy_DetailsDao;
import com.medplus.insurance.policy.dao.Policy_DetailsDaoImpl;

public class Policy_DetailsServiceImpl implements Policy_DetailsService{

	Policy_DetailsDao policy_DetailsDao = new Policy_DetailsDaoImpl();
	@Override
	public int createPolicyDetail(Policy_Details policy_Detail) {
		int result = policy_DetailsDao.createPolicyDetail(policy_Detail);
		return result;
	}

}
