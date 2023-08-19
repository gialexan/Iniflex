package br.com.projedata.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	
	private String		name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate	birthDate;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, LocalDate birthDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}




//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (1, timestamp'2000-10-18', 'MARIA', 'OPERADOR', 2009.44);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (2, timestamp'1990-05-12', 'JOÃO', 'OPERADOR', 2284.38);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (3, timestamp'1961-05-02', 'CAIO', 'COORDENADOR', 9836.14);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (4, timestamp'1988-10-14', 'MIGUEL', 'DIRETOR', 19119.88);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (5, timestamp'1995-01-05', 'ALICE', 'RECEPCIONISTA', 2234.68);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (6, timestamp'1999-11-19', 'HEITOR', 'OPERADOR', 1582.72);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (7, timestamp'1993-03-31', 'ARTHUR', 'CONTADOR', 4071.84);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (8, timestamp'1994-07-08', 'LAURA', 'GERENTE', 3017.45);
//INSERT INTO TB_EMPLOYEE (ID, BIRTH_DATE, NAME, FUNCTION, SALARY)  VALUES (9, timestamp'2003-05-24', 'HELOÍSA', 'ELETRICISTA', 1606.85);
