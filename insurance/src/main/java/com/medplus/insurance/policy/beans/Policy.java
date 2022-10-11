package com.medplus.insurance.policy.beans;

public class Policy {
	private int policy_number;
	private double policy_premium;
	private long account_number;
	
	public Policy() {
		// TODO Auto-generated constructor stub
	}

	public Policy(int policy_number, double policy_premium, long account_number) {
		super();
		this.policy_number = policy_number;
		this.policy_premium = policy_premium;
		this.account_number = account_number;
	}

	public int getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(int policy_number) {
		this.policy_number = policy_number;
	}

	public double getPolicy_premium() {
		return policy_premium;
	}

	public void setPolicy_premium(double policy_premium) {
		this.policy_premium = policy_premium;
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	@Override
	public String toString() {
		return "Policy [policy_number=" + policy_number + ", policy_premium=" + policy_premium + ", account_number="
				+ account_number + "]";
	}
	
	
	
}
