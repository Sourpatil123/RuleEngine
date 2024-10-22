package com.ruleengines.Service;

import java.util.List;

import com.ruleengines.Reposotery.EvaluateWithDataRepository;
import com.ruleengines.entity.EvaluateWithData;

public interface EvaluationServiceInterface {

	void addEvaluationData(EvaluateWithData evaluateWithData);
	
	List<EvaluateWithData> getAllEvaluations();
	
	boolean evaluateRule(String condition, int age, String department, double salary, int experience);
}
