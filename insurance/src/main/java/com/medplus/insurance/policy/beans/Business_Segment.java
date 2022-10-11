package com.medplus.insurance.policy.beans;

public class Business_Segment {
	private String bus_seg_id;
	private int bus_seg_seq;
	private String bus_seg_name;
	
	public Business_Segment() {
		// TODO Auto-generated constructor stub
	}

	public Business_Segment(String bus_seg_id, int bus_seg_seq, String bus_seg_name) {
		super();
		this.bus_seg_id = bus_seg_id;
		this.bus_seg_seq = bus_seg_seq;
		this.bus_seg_name = bus_seg_name;
	}

	public String getBus_seg_id() {
		return bus_seg_id;
	}

	public void setBus_seg_id(String bus_seg_id) {
		this.bus_seg_id = bus_seg_id;
	}

	public int getBus_seg_seq() {
		return bus_seg_seq;
	}

	public void setBus_seg_seq(int bus_seg_seq) {
		this.bus_seg_seq = bus_seg_seq;
	}

	public String getBus_seg_name() {
		return bus_seg_name;
	}

	public void setBus_seg_name(String bus_seg_name) {
		this.bus_seg_name = bus_seg_name;
	}

	@Override
	public String toString() {
		return "Business_Segment [bus_seg_id=" + bus_seg_id + ", bus_seg_seq=" + bus_seg_seq + ", bus_seg_name="
				+ bus_seg_name + "]";
	}
	
	
}
