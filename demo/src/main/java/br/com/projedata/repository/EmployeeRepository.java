package br.com.projedata.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.projedata.entity.Employee;
import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE TB_EMPLOYEE SET SALARY = SALARY * 1.1", nativeQuery = true)
	public void updateSalary();

	@Query(value = "SELECT SUM(SALARY) FROM TB_EMPLOYEE", nativeQuery = true)
	public BigDecimal sumSalary();
	
	@Query(value = "SELECT * FROM TB_EMPLOYEE ORDER BY NAME", nativeQuery = true)
	public List<Employee> alphabeticalOrder();
	
	@Query(value = "SELECT NAME, TRUNCATE((DATEDIFF(DAY, BIRTH_DATE, CURRENT_DATE)/365.25), 0) AS AGE FROM TB_EMPLOYEE ORDER BY BIRTH_DATE LIMIT 1;", nativeQuery = true)
	public String getOldestPerson();
}



//
//SELECT
//NAME,
//TRUNCATE((DATEDIFF(DAY, BIRTH_DATE, CURRENT_DATE) / 365.25), 0) AS AGE
//FROM TB_EMPLOYEE
//ORDER BY BIRTH_DATE
//LIMIT 1;