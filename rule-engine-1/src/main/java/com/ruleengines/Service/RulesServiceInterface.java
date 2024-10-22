package com.ruleengines.Service;

import java.util.List;
import java.util.Map;

import com.ruleengines.Model.ASTNode;
import com.ruleengines.entity.Rule;

public interface RulesServiceInterface {
	
	List<Rule> getAllRules();
	
	void addRule(Rule rule);
	
	String evaluateCondition(String condition);
	
	ASTNode parseRuleToAST(String ruleString);
	
	boolean evaluateRule(ASTNode root, Map<String, Object> userData);
	
	ASTNode combineRules(List<ASTNode> rules);

}
