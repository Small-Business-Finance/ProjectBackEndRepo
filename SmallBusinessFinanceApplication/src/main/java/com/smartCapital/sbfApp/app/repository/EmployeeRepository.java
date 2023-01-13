package com.smartCapital.sbfApp.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartCapital.sbfApp.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Transactional
	public Employee findByEmpId(Integer empId);
}
