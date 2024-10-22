package com.ruleengines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EvaluateWithData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	 int age;
	 String department;
	 double salary;
	 int experience;
	 String result;
	public EvaluateWithData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EvaluateWithData(Long id, int age, String department, double salary, int experience, String result) {
		super();
		this.id = id;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.experience = experience;
		this.result = result;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	

}
