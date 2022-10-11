package com.medplus.insurance.policy.beans;

public class Policy_Questions {
	private String pol_ques_id;
	private int pol_ques_seq;
	private String bus_seg_id;
	private String pol_ques_desc;
	private String pol_ques_ans1;
	private int pol_ques_ans1_weightage;
	private String pol_ques_ans2;
	private int pol_ques_ans2_weightage;
	private String pol_ques_ans3;
	private int pol_ques_ans3_weightage;
	
	public Policy_Questions() {
		// TODO Auto-generated constructor stub
	}

	public Policy_Questions(String pol_ques_id, int pol_ques_seq, String bus_seg_id, String pol_ques_desc,
			String pol_ques_ans1, int pol_ques_ans1_weightage, String pol_ques_ans2, int pol_ques_ans2_weightage,
			String pol_ques_ans3, int pol_ques_ans3_weightage) {
		super();
		this.pol_ques_id = pol_ques_id;
		this.pol_ques_seq = pol_ques_seq;
		this.bus_seg_id = bus_seg_id;
		this.pol_ques_desc = pol_ques_desc;
		this.pol_ques_ans1 = pol_ques_ans1;
		this.pol_ques_ans1_weightage = pol_ques_ans1_weightage;
		this.pol_ques_ans2 = pol_ques_ans2;
		this.pol_ques_ans2_weightage = pol_ques_ans2_weightage;
		this.pol_ques_ans3 = pol_ques_ans3;
		this.pol_ques_ans3_weightage = pol_ques_ans3_weightage;
	}

	public String getPol_ques_id() {
		return pol_ques_id;
	}

	public void setPol_ques_id(String pol_ques_id) {
		this.pol_ques_id = pol_ques_id;
	}

	public int getPol_ques_seq() {
		return pol_ques_seq;
	}

	public void setPol_ques_seq(int pol_ques_seq) {
		this.pol_ques_seq = pol_ques_seq;
	}

	public String getBus_seg_id() {
		return bus_seg_id;
	}

	public void setBus_seg_id(String bus_seg_id) {
		this.bus_seg_id = bus_seg_id;
	}

	public String getPol_ques_desc() {
		return pol_ques_desc;
	}

	public void setPol_ques_desc(String pol_ques_desc) {
		this.pol_ques_desc = pol_ques_desc;
	}

	public String getPol_ques_ans1() {
		return pol_ques_ans1;
	}

	public void setPol_ques_ans1(String pol_ques_ans1) {
		this.pol_ques_ans1 = pol_ques_ans1;
	}

	public int getPol_ques_ans1_weightage() {
		return pol_ques_ans1_weightage;
	}

	public void setPol_ques_ans1_weightage(int pol_ques_ans1_weightage) {
		this.pol_ques_ans1_weightage = pol_ques_ans1_weightage;
	}

	public String getPol_ques_ans2() {
		return pol_ques_ans2;
	}

	public void setPol_ques_ans2(String pol_ques_ans2) {
		this.pol_ques_ans2 = pol_ques_ans2;
	}

	public int getPol_ques_ans2_weightage() {
		return pol_ques_ans2_weightage;
	}

	public void setPol_ques_ans2_weightage(int pol_ques_ans2_weightage) {
		this.pol_ques_ans2_weightage = pol_ques_ans2_weightage;
	}

	public String getPol_ques_ans3() {
		return pol_ques_ans3;
	}

	public void setPol_ques_ans3(String pol_ques_ans3) {
		this.pol_ques_ans3 = pol_ques_ans3;
	}

	public int getPol_ques_ans3_weightage() {
		return pol_ques_ans3_weightage;
	}

	public void setPol_ques_ans3_weightage(int pol_ques_ans3_weightage) {
		this.pol_ques_ans3_weightage = pol_ques_ans3_weightage;
	}

	@Override
	public String toString() {
		return "Policy_Questions [pol_ques_id=" + pol_ques_id + ", pol_ques_seq=" + pol_ques_seq + ", bus_seg_id="
				+ bus_seg_id + ", pol_ques_desc=" + pol_ques_desc + ", pol_ques_ans1=" + pol_ques_ans1
				+ ", pol_ques_ans1_weightage=" + pol_ques_ans1_weightage + ", pol_ques_ans2=" + pol_ques_ans2
				+ ", pol_ques_ans2_weightage=" + pol_ques_ans2_weightage + ", pol_ques_ans3=" + pol_ques_ans3
				+ ", pol_ques_ans3_weightage=" + pol_ques_ans3_weightage + "]";
	}
	
	public String getAnsStringByWeightage(int weightage) {
		if(weightage == 200)
			return getPol_ques_ans1();
		else if (weightage == 400) {
			return getPol_ques_ans2();
		}else if (weightage == 600) {
			return getPol_ques_ans3();
		}else {
			return null;
		}
	}
	
	
}
