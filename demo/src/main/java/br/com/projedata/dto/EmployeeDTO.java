package br.com.projedata.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
	
	private String		name;
	
	private String		birthDate;
	
	private int			id;

	private BigDecimal	intSalary;

	private String		strSalary;
	
	private String		function;

	private BigDecimal 	amountMinWages;

	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(String name, String birthDate, int id, BigDecimal intSalary, String strSalary, String function,
			BigDecimal amountMinWages) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.id = id;
		this.intSalary = intSalary;
		this.strSalary = strSalary;
		this.function = function;
		this.amountMinWages = amountMinWages;
	}

	public EmployeeDTO(int i, String string, BigDecimal bigDecimal, String string2, BigDecimal bigDecimal2) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getIntSalary() {
		return intSalary;
	}

	public void setIntSalary(BigDecimal intSalary) {
		this.intSalary = intSalary;
	}

	public String getStrSalary() {
		return strSalary;
	}

	public void setStrSalary(String strSalary) {
		this.strSalary = strSalary;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public BigDecimal getAmountMinWages() {
		return amountMinWages;
	}

	public void setAmountMinWages(BigDecimal amountMinWages) {
		this.amountMinWages = amountMinWages;
	}
}
