package br.com.projedata.resouce;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projedata.dto.EmployeeDTO;
import br.com.projedata.entity.Employee;
import br.com.projedata.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

	@Autowired
	EmployeeService service;

	@GetMapping
	public List<EmployeeDTO> findAll() {
		return (service.findAll());
	}

	@GetMapping("/get-by-id/{id}")
	public Employee findById(@PathVariable int id) {
		return (service.findById(id));
	}

	@GetMapping("/delete-by-id/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@GetMapping("/update-salary")
	public void	updateSalary() {
		service.updateSalary();
	}

	@GetMapping("/get-sum-salary")
	public BigDecimal sumSalary() {
		return (service.sumSalary());
	}

	@GetMapping("/get-alphabetical-order")
	public List<Employee> alphabeticalOrder( ) {
		return (service.alphabeticalOrder());
	}

	@GetMapping("/get-oldest-employee")
	public String getOldestPerson() {
		return (service.getOldestPerson());
	}

	@GetMapping("/get-employees-by-function")
	public List<String> getEmployeesByFunction() {
		return (service.getEmployeesByFunction());
	}

	@GetMapping("/get-employees-birthday-oct-to-dec")
	public List<Employee> getEmployeesBirthdayOctToDec() {
		return (service.getEmployeesBirthdayOctToDec());
	}

	@GetMapping("/get-minimum-wage-count-by-employees")
	public List<EmployeeDTO> getMinimumWageCountbyEmployees() {
		return (service.getMinimumWageCountbyEmployees());
	}

	@GetMapping("/group-employees-by-function-in-map")
	public Map<String, List<Employee>> getEmployeesByFuctionInMap() {
		return (service.getEmployeesByFuctionInMap());
	}
}
