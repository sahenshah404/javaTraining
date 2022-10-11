package com.medplus.insurance.policy.service;

import java.util.ArrayList;
import java.util.List;

import com.medplus.insurance.policy.beans.Accounts;
import com.medplus.insurance.policy.dao.AccountsDao;
import com.medplus.insurance.policy.dao.AccountsImpl;

public class AccountsServiceImpl implements AccountsService{

	AccountsDao accountsDao = new AccountsImpl();
	
	@Override
	public Accounts findAccountByUsername(String username) {
		Accounts account = accountsDao.findAccountByUsername(username);
		return account;
	}

	@Override
	public String createAccount(String insured_name, String insured_street, String insured_city, String insured_state,
			int insured_zip, String business_segment, String insuredId, String agentId) {
		long account_number = 0;
		long maxAccount_number = accountsDao.getMaxAccountNumber();
		if(maxAccount_number < 9999) {
			account_number = 10001;
		}
		else {
			account_number = maxAccount_number +1;
		}
		Accounts account = new Accounts(account_number, insured_name, insured_street, 
				insured_city, insured_state, insured_zip, business_segment, insuredId, agentId);
		
		int result = accountsDao.createAccount(account);
		if(result > 0) {
			return "Account Created";
		}
		else {			
			return "Accoutn could not be created.";
		}
	}

	@Override
	public List<Accounts> getInsuredForAdmin() {
		List<Accounts> accounts = new ArrayList<Accounts>();
		accounts = accountsDao.getAllAccounts();
		return accounts;
	}

	@Override
	public List<Accounts> getInsuredForAgent(String agentId) {
		List<Accounts> accounts = new ArrayList<Accounts>();
		accounts = accountsDao.getInsuredForAgent(agentId);
		return accounts;
	}

	@Override
	public String getBusSegByUsername(String username) {
		Accounts account = accountsDao.findAccountByUsername(username);
		return account.getBusiness_segment();
	}

}
