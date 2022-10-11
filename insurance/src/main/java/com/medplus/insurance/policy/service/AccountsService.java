package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.Accounts;

public interface AccountsService {
	Accounts findAccountByUsername(String username);

	String createAccount(String insured_name, String insured_street, String insured_city, String insured_state,
			int insured_zip, String business_segment, String insuredId, String agentId);

	List<Accounts> getInsuredForAdmin();
	List<Accounts> getInsuredForAgent(String agentId);

	String getBusSegByUsername(String username);


}
