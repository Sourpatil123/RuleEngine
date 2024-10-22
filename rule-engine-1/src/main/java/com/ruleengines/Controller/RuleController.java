package com.ruleengines.Controller;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.ruleengines.EvaluateService.EvaluateService;
import com.ruleengines.Model.ASTNode;
import com.ruleengines.Service.RuleService;

import com.ruleengines.entity.EvaluateWithData;
import com.ruleengines.entity.Rule;

import ch.qos.logback.core.joran.conditional.Condition;

@Controller
public class RuleController {
	
	@Autowired
    private RuleService rserv;
    
    @Autowired
    private com.ruleengines.Service.EvaluateService evaluateService;

    @GetMapping("/")
    public String index(Model model) {
        List<Rule> rules = rserv.getAllRules();
        model.addAttribute("rules", rules);
        return "index";
    }

    @PostMapping("/addRule")
    public String addRule(Rule rule) {
        rserv.addRule(rule);
        return "redirect:/";
    }

    @GetMapping("/evaluate")
    public String evaluateCondition(@RequestParam String condition, Model model) {
        String result = rserv.evaluateCondition(condition);
        model.addAttribute("result", result);
        return "index";
    }

    @PostMapping("/evaluateWithData")
    public String evaluateWithData(@RequestParam int age, @RequestParam String department, 
                                   @RequestParam double salary, @RequestParam int experience, @RequestParam String condition,
                                   Model model) {

    	boolean isEligible = rserv.evaluateRule(condition,age,department, salary,experience);
    	
    	String result = isEligible ? "User matches the condition." : "User does not match condition.";
    	
    	EvaluateWithData evalData = new EvaluateWithData();
    	evalData.setAge(age);
    	evalData.setDepartment(department);
    	evalData.setSalary(salary);
    	evalData.setExperience(experience);
    	evalData.setResult(result);
    	
    	evaluateService.addEvaluationData(evalData);
    	
    	model.addAttribute("result", result);
		return "index";
    	

    }
}

	
			//return false;
