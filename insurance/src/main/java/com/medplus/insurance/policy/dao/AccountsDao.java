package com.medplus.insurance.policy.dao;

import java.util.List;

import com.medplus.insurance.policy.beans.Accounts;

public interface AccountsDao {
	Accounts findAccountByUsername(String username);
	long getMaxAccountNumber();
	int createAccount(Accounts account);
//	List<Accounts> getInsuredForAdmin();
	List<Accounts> getAllAccounts();
	List<Accounts> getInsuredForAgent(String agentId);
}
