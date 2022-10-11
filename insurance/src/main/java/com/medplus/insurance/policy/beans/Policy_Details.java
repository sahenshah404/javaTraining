package com.medplus.insurance.policy.beans;

public class Policy_Details {
	private long policy_number;
	private String question_id;
	private String answer;
	
	public Policy_Details() {
		// TODO Auto-generated constructor stub
	}

	public Policy_Details(long policy_number, String question_id, String answer) {
		super();
		this.policy_number = policy_number;
		this.question_id = question_id;
		this.answer = answer;
	}

	public long getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(long policy_number) {
		this.policy_number = policy_number;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Policy_Details [policy_number=" + policy_number + ", question_id=" + question_id + ", answer=" + answer
				+ "]";
	};
	
	
	
}
