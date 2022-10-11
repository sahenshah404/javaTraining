package com.medplus.insurance.policy.dao;

import java.util.List;

import com.medplus.insurance.policy.beans.Policy_Questions;

public interface Policy_QuestionsDao {

	List<Policy_Questions> getPolicyQues(String busSegId);

}
