package br.com.projedata.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
	
	private int			id;

	private String		name;

	private BigDecimal	salary;
	
	private String		function;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate	birthDate;
	
	private BigDecimal 	qntSalMin;

	public EmployeeDTO() {
		super();
	}
	
	public EmployeeDTO(int id, String name, BigDecimal salary, String function, LocalDate birthDate, BigDecimal qntSalMin) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.function = function;
		this.birthDate = birthDate;
		this.qntSalMin = qntSalMin;
	}

	public BigDecimal getQntSalMin() {
		return qntSalMin;
	}

	public void setQntSalMin(BigDecimal qntSalMin) {
		this.qntSalMin = qntSalMin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
