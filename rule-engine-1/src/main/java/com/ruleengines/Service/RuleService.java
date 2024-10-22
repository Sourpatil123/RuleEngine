package com.ruleengines.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruleengines.Model.ASTNode;
import com.ruleengines.Reposotery.RuleRepository;
import com.ruleengines.entity.Rule;

@Service
public class RuleService implements RulesServiceInterface {

	@Autowired
	private RuleRepository rrepo;
	
	public List<Rule> getAllRules() {
		// TODO Auto-generated method stub
		return rrepo.findAll();
	}

	public void addRule(Rule rule) {
		// TODO Auto-generated method stub
		rrepo.save(rule);
		
	}
	
	public ASTNode parseRuleToAST(String ruleString) {
		
		Stack<ASTNode> stack = new Stack<>();
		
		return new ASTNode("operand", ruleString);
	}
	
	public boolean evaluateRule(ASTNode root, Map<String, Object> userData) {
		
		if(root == null) return false;
		
		if("operand".equals(root.getType())) {
			String condition = root.getValue();
			return true;
		}
		boolean leftResult = evaluateRule(root.getLeft(), userData);
		boolean rightResult = evaluateRule(root.getRight(), userData);
		
		switch (root.getType()) {
		case "AND": return leftResult && rightResult;
		case "OR" : return leftResult || rightResult;
		default : return false;
		}
	}
	
	public ASTNode combineRules(List<ASTNode> rules) {
		
		if(rules == null || rules.isEmpty()) return null;
		ASTNode combined = rules.get(0);
		
		for (int i = 1; i < rules.size(); i++) {
			combined = new ASTNode("OR", combined,rules.get(i));
		}
		
		return combined;
	}

	public String evaluateCondition(String condition) {
//		// TODO Auto-generated method stub
//		for(Rule rule : rrepo.findAll()) {
//			if(rule.getRuleCondition().equals(condition)) {
//				return "Action:" + rule.getAction();
		ASTNode root = parseRuleToAST(condition);
		Map<String, Object> sampleData = Map.of(
				"age", 35,
				"department", "sales",
				"salary", 60000,
				"experience", 3
				);
		
		boolean result = evaluateRule(root, sampleData);
		return result ? "Rule matched." : "Rule did not match.";
			}
		
	
		public boolean evaluateRule(String condition, int age, String department, double salary, int experience) {
			return condition.contains("age > 30") && age > 30 && department.equals("sales");
		}


	}


