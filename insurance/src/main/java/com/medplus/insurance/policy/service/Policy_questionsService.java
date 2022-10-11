package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.Policy_Questions;

public interface Policy_questionsService {

	List<Policy_Questions> getPolicyQues(String busSegId);

}
