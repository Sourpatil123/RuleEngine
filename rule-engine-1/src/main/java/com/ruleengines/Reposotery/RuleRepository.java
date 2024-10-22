package com.ruleengines.Reposotery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruleengines.entity.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long>{

	List<Rule> findAll();

}
