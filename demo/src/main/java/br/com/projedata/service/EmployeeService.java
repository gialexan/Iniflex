package br.com.projedata.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projedata.entity.Employee;
import br.com.projedata.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public Employee findById(int id){
		return (repository.findById(id).get());
	}

	public List<Employee> findAll(){
		return (repository.findAll());
	}

	public void	deleteById(int id) {
		repository.deleteById(id);
	}

	public void updateSalary() {
		repository.updateSalary();
	}

	public BigDecimal sumSalary() {
		return (repository.getSumSalary());
	}
	
	public List<Employee> alphabeticalOrder() {
		return (repository.getAlphabeticalOrder());
	}
	
	public String getOldestPerson() {
		return (repository.getOldestPerson());
	}
	
	public List<String> getEmployeesByFunction () {
		return (repository.getEmployeesByFunction());
	}
}

