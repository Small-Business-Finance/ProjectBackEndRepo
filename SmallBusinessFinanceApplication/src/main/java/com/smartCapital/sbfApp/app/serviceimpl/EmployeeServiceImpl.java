package com.smartCapital.sbfApp.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartCapital.sbfApp.app.model.Employee;
import com.smartCapital.sbfApp.app.repository.EmployeeRepository;
import com.smartCapital.sbfApp.app.service.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	@Autowired
	EmployeeRepository employeerepository;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeerepository.save(employee);		
	}

	@Override
	public void updateEmployee(Integer empId, Employee employee) {
		Employee empupdate=employeerepository.findByEmpId(empId);
		
		empupdate.setEmpId(employee.getEmpId());
		empupdate.setEmpName(employee.getEmpName());
		empupdate.setEmpDateofBirth(employee.getEmpDateofBirth());
		empupdate.setEmpId(employee.getEmpId());
		empupdate.setEmpId(employee.getEmpId());
		empupdate.setEmpId(employee.getEmpId());
		empupdate.setEmpId(employee.getEmpId());
		empupdate.setEmpId(employee.getEmpId());
		empupdate.setEmpId(employee.getEmpId());
	}

	@Override
	public void deleteEmployee(Integer empId) {
		employeerepository.deleteById(empId);
		
	}

	@Override
	public Iterable<Employee> getEmployee() {
		
		return employeerepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(Integer empId) {
		return employeerepository.findByEmpId(empId);
	}
	

}
