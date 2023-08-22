package br.com.projedata.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

	public List<EmployeeDTO> findAll(){
		List<Employee> employees = repository.findAll();
	    List<EmployeeDTO> employeeDTOs = employees.stream()
		        .map(x -> {
		            EmployeeDTO dto = new EmployeeDTO();
		            dto.setId((int) x.getId());
		            dto.setName((String) x.getName());
		            dto.setStrSalary(new DecimalFormat("#,##0.00").format(x.getSalary()));
		            dto.setFunction((String) x.getFunction());
		            dto.setBirthDate(x.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		            return dto;
		        })
		        .collect(Collectors.toList());
		    return (employeeDTOs);
	}

	public void	deleteById(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public List<Employee> getEmployeesBirthdayOctToDec() {
		return (repository.getEmployeesBirthdayOctToDec());
	}
	
	public List<EmployeeDTO> getMinimumWageCountbyEmployees() {
	    List<Map<String, Object>> employees = repository.getMinimumWageCountbyEmployees();
	    List<EmployeeDTO> employeeDTOs = employees.stream()
	        .map(x -> {
	            EmployeeDTO dto = new EmployeeDTO();
	            dto.setId((int) x.get("ID"));
	            dto.setName((String) x.get("NAME"));
	            dto.setIntSalary((BigDecimal) x.get("SALARY"));
	            dto.setFunction((String) x.get("FUNCTION"));
	            dto.setAmountMinWages((BigDecimal) x.get("AMOUNTH_MIN_WAGES"));
	            return dto;
	        })
	        .collect(Collectors.toList());
	    return (employeeDTOs);
	}

	public Map<String, List<Employee>> getEmployeesByFuctionInMap() {
		List<Employee> employees = repository.findAll();
		Map<String, List<Employee>> employeeMap = employees.stream()
	            .collect(Collectors.groupingBy(Employee::getFunction, TreeMap::new, Collectors.toList()));				
		return (employeeMap);
	}
}
