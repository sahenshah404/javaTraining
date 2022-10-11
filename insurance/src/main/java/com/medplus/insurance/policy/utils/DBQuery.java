package com.medplus.insurance.policy.utils;

public class DBQuery {
	// User_ROle
	public static final String FINDBYUSER_NAME = 
			"select user_name,password,role_code from user_role where user_name = ?";
	public static final String CREATEUSER = 
			"insert into user_role values(?,?,?);";
	public static final String GETALLAGENTS = 
			"select user_name,role_code from user_role where role_code = 'agent';";
	public static final String GETALLINSUREDS = 
			"select user_name,role_code from user_role where role_code = 'insured';";

	// Accounts
	public static final String CREATEACCOUNT =
			"insert into accounts values(?,?,?,?,?,?,?,?,?);";
	public static final String FINDACCOUNTBYUSERNAME = 
			"select account_number, insured_name, insured_street, insured_city,"
			+ " insured_state, insured_zip, business_segment, user_name, agent"
			+ " from accounts where user_name = ?;";
	public static final String GETMAXACCOUNTNUMBER = 
			"select max(account_number) from accounts;";
	public static final String GETALLACCOUNTS=
			"select account_number, insured_name,business_segment,user_name "
			+ "from accounts;";
	public static final String GETINSUREDFORAGENT=
			"select account_number, insured_name,business_segment,user_name "
			+ "from accounts where agent= ?;";
	
	
	//Business_segment
	public static final String GETALLBUSSEG = 
			"select bus_seg_id, bus_seg_seq, bus_seg_name from business_segment;";
	
	//Policy_questions
	public static final String GETPOLICYQUESFORBUSSEG = 
			"select pol_ques_id, pol_ques_seq, bus_seg_id, pol_ques_desc,"
			+ "pol_ques_ans1, pol_ques_ans1_weightage,"
			+ "pol_ques_ans2, pol_ques_ans2_weightage,"
			+ "pol_ques_ans3, pol_ques_ans3_weightage "
			+ "from policy_questions where bus_seg_id = ?;";
	
	//Policy
	public static final String GETALLPOLICY = 
			"select policy_number, policy_premium, account_number from policy;";
	public static final String GETMAXPOLICYNUMBER = 
			"select max(policy_number) from policy;";
	public static final String CREATEPOLICY = 
			"insert into policy values(?,?,?);";
	public static final String GETPOLICYFORACCOUNT =
			"select policy_number, policy_premium, account_number from policy"
			+ " where account_number = ?;";
	public static final String GETPOLICYFORAGENT = 
			"select b.policy_number, b.policy_premium, a.account_number from accounts a"
			+ " inner join policy b on a.account_number = b.account_number"
			+ " where a.agent = ? ;";
	
	//PolicyDetails
	public static final String CREATEPOLICYDETAILS = 
			"insert into policy_details values(?,?,?);";
}
