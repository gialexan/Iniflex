package br.com.projedata.entity;

import java.math.BigDecimal;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EMPLOYEE")
public class Employee extends Person {
	
	
	@Id
	private	int			id;

	private BigDecimal	salary;
	
	private String		function;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, LocalDate birthDate) {
		super(name, birthDate);
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, BigDecimal salary, String function) {
		super();
		this.id = id;
		this.salary = salary;
		this.function = function;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
}
