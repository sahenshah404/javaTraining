package com.medplus.insurance.policy.service;

import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.Accounts;
import com.medplus.insurance.policy.beans.Policy;
import com.medplus.insurance.policy.dao.PolicyDao;
import com.medplus.insurance.policy.dao.PolicyDaoImpl;

public class PolicyServiceImpl implements PolicyService {

	PolicyDao policyDao = new PolicyDaoImpl();
	AccountsService accountsService = new AccountsServiceImpl();

	@Override
	public int createPolicy(long account_number, int premium) {
		// TODO Auto-generated method stub
		int maxPolNum = policyDao.getMaxpolicyNumber();
		if (maxPolNum < 99999) {
			maxPolNum = 100001;
		} else {
			maxPolNum++;
		}

		Policy policy = new Policy(maxPolNum, premium, account_number);
		int result = policyDao.createPolicy(policy);
		if (result > 0)
			return maxPolNum;
		else
			return 0;
	}

	@Override
	public List<Policy> getPolicies(String username, String role) {
		List<Policy> policies = new ArrayList<Policy>();
		
		if (role.equals("admin")) {
			policies = policyDao.getAllPolicy();
		}
		else if (role.equals("agent")) {
			 policies = policyDao.getPolicyForAgent(username);
		}
		else if (role.equals("insured")) {
			Accounts account =  accountsService.findAccountByUsername(username);
			policies = policyDao.getPolicyByAccountNum(account.getAccount_number());
		}
		
		return policies;
	}

}
