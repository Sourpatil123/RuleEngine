package com.ruleengines.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruleengines.Reposotery.EvaluateWithDataRepository;
import com.ruleengines.entity.EvaluateWithData;

@Service
public class EvaluateService implements EvaluationServiceInterface{
	
	
	    @Autowired
	    private EvaluateWithDataRepository evaluateRep;

	    @Override
	    public void addEvaluationData(EvaluateWithData evaluationData) {
	        evaluateRep.save(evaluationData);
	    }

	    @Override
	    public List<EvaluateWithData> getAllEvaluations() {
	        return evaluateRep.findAll();

}
	    
	   

		@Override
		public boolean evaluateRule(String condition, int age, String department, double salary, int experience) {
			// TODO Auto-generated method stub
			if(condition.contains("age") && age > 30 && condition.contains("department") && department.equals("sales")) {
	    		return true;
			}
			return false;
		}

		
}
