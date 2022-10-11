package com.medplus.insurance.policy.beans;

public class Accounts {
private long account_number;
private String insured_name;
private String insured_street;
private String insured_city;
private String insured_state;
private int insured_zip;
private String business_segment;
private String user_name;
private String agent;

public Accounts() {
	// TODO Auto-generated constructor stub
}

public Accounts(long account_number, String insured_name, String insured_street, String insured_city,
		String insured_state, int insured_zip, String business_segment, String user_name, String agent) {
	super();
	this.account_number = account_number;
	this.insured_name = insured_name;
	this.insured_street = insured_street;
	this.insured_city = insured_city;
	this.insured_state = insured_state;
	this.insured_zip = insured_zip;
	this.business_segment = business_segment;
	this.user_name = user_name;
	this.agent = agent;
}

public long getAccount_number() {
	return account_number;
}

public void setAccount_number(long account_number) {
	this.account_number = account_number;
}

public String getInsured_name() {
	return insured_name;
}

public void setInsured_name(String insured_name) {
	this.insured_name = insured_name;
}

public String getInsured_street() {
	return insured_street;
}

public void setInsured_street(String insured_street) {
	this.insured_street = insured_street;
}

public String getInsured_city() {
	return insured_city;
}

public void setInsured_city(String insured_city) {
	this.insured_city = insured_city;
}

public String getInsured_state() {
	return insured_state;
}

public void setInsured_state(String insured_state) {
	this.insured_state = insured_state;
}

public int getInsured_zip() {
	return insured_zip;
}

public void setInsured_zip(int insured_zip) {
	this.insured_zip = insured_zip;
}

public String getBusiness_segment() {
	return business_segment;
}

public void setBusiness_segment(String business_segment) {
	this.business_segment = business_segment;
}

public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public String getAgent() {
	return agent;
}

public void setAgent(String agent) {
	this.agent = agent;
}

@Override
public String toString() {
	return "Accounts [account_number=" + account_number + ", insured_name=" + insured_name + ", insured_street="
			+ insured_street + ", insured_city=" + insured_city + ", insured_state=" + insured_state + ", insured_zip="
			+ insured_zip + ", business_segment=" + business_segment + ", user_name=" + user_name + ", agent=" + agent
			+ "]";
};



}
