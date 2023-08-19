package br.com.projedata.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projedata.dto.EmployeeDTO;
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
	
	public List<String> getEmployeesBirthdayOctToDec() {
		return (repository.getEmployeesBirthdayOctToDec());
	}
	
	public List<EmployeeDTO> getMinimumWageCountbyEmployees() {
	    List<Map<String, Object>> employees = repository.getMinimumWageCountbyEmployees();
	    List<EmployeeDTO> employeeDTOs = employees.stream()
	        .map(x -> {
	            EmployeeDTO dto = new EmployeeDTO();
	            dto.setId((int) x.get("ID"));
	            dto.setName((String) x.get("NAME"));
	            dto.setSalary((BigDecimal) x.get("SALARY"));
	            dto.setFunction((String) x.get("FUNCTION"));
	            dto.setQntSalMin((BigDecimal) x.get("QNT_SAL_MIN"));
	            return dto;
	        })
	        .collect(Collectors.toList());
	    return (employeeDTOs);
	}
}

