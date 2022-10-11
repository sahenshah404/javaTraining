package com.medplus.insurance.policy.service;

import java.util.List;

import com.medplus.insurance.policy.beans.Policy_Questions;
import com.medplus.insurance.policy.dao.Policy_QuestionsDao;
import com.medplus.insurance.policy.dao.Policy_QuestionsDaoImpl;

public class Policy_questionsServiceImpl implements Policy_questionsService{

	Policy_QuestionsDao policy_QuestionsDao = new Policy_QuestionsDaoImpl();
	@Override
	public List<Policy_Questions> getPolicyQues(String busSegId) {
		List<Policy_Questions> policy_Questions = policy_QuestionsDao.getPolicyQues(busSegId);
		
		return  policy_Questions;
	}

}
