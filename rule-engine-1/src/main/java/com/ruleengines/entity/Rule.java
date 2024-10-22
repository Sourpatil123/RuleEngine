package com.ruleengines.entity;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String ruleCondition;
	String action;
	public Rule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rule(Long id, String ruleCondition, String action) {
		super();
		this.id = id;
		this.ruleCondition = ruleCondition;
		this.action = action;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRuleCondition() {
		return ruleCondition;
	}
	public void setRuleCondition(String ruleCondition) {
		this.ruleCondition = ruleCondition;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "Rule [id=" + id + ", ruleCondition=" + ruleCondition + ", action=" + action + "]";
	}
	
	
	
    
    
    
}
