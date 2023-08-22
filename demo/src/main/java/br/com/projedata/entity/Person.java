package br.com.projedata.entity;

import java.time.LocalDate;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	
	private String		name;
	
	private LocalDate	birthDate;

	public Person() {
		super();
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
