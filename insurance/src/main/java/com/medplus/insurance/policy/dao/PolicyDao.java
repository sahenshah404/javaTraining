package com.medplus.insurance.policy.dao;


import java.util.List;

import com.medplus.insurance.policy.beans.Policy;

public interface PolicyDao {
	int getMaxpolicyNumber();
	int createPolicy(Policy policy);
	List<Policy> getAllPolicy();
	List<Policy> getPolicyForAgent(String username);
	List<Policy> getPolicyByAccountNum(long account_number);
	
}
