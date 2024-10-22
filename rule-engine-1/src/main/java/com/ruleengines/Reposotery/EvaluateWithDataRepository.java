package com.ruleengines.Reposotery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruleengines.entity.EvaluateWithData;
import com.ruleengines.entity.Rule;

public interface EvaluateWithDataRepository extends JpaRepository<EvaluateWithData, Long>{

	List<EvaluateWithData> findAll();
	
	
}
