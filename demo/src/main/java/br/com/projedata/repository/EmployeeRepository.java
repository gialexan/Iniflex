package br.com.projedata.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
	public BigDecimal getSumSalary();

	@Query(value = "SELECT * FROM TB_EMPLOYEE ORDER BY NAME", nativeQuery = true)
	public List<Employee> getAlphabeticalOrder();

	@Query(value = "SELECT NAME, TRUNCATE((DATEDIFF(DAY, BIRTH_DATE, CURRENT_DATE)/365.25), 0) AS AGE FROM TB_EMPLOYEE ORDER BY BIRTH_DATE LIMIT 1;", nativeQuery = true)
	public String getOldestPerson();

	@Query(value = "SELECT e.FUNCTION, GROUP_CONCAT(e.NAME) AS EMPLOYEES FROM TB_EMPLOYEE e GROUP BY FUNCTION;", nativeQuery = true)
	public List<String> getEmployeesByFunction();

	@Query(value = "SELECT NAME, FORMATDATETIME(BIRTH_DATE, 'dd/MM/yyyy')FROM TB_EMPLOYEE WHERE EXTRACT(MONTH FROM BIRTH_DATE) BETWEEN 10 AND 12;", nativeQuery = true)
	public List<String> getEmployeesBirthdayOctToDec();

	@Query(value = "SELECT ID, NAME, SALARY, FUNCTION, TRUNC((SALARY / 1212.00), 0) AS QNT_SAL_MIN FROM TB_EMPLOYEE WHERE SALARY > 1212.00", nativeQuery = true)
	public List<Map<String, Object>> getMinimumWageCountbyEmployees();
}
