package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.Policy;

public interface PolicyService {
	int createPolicy(long account_number, int premium);

	List<Policy> getPolicies(String username, String role);

}
