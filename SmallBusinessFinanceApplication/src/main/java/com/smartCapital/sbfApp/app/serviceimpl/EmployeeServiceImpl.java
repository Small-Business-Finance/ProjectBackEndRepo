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
		
		empupdate.setEmpName(employee.getEmpName());
		empupdate.setEmpDateofBirth(employee.getEmpDateofBirth());
		empupdate.setEmpGender(employee.getEmpGender());
		empupdate.setEmpSalary(employee.getEmpSalary());
		empupdate.setEmpRole(employee.getEmpRole());
		empupdate.setEmpAddress(employee.getEmpAddress());
		empupdate.setEmpMobileno(employee.getEmpMobileno());
		empupdate.setEmpEmailId(employee.getEmpEmailId());
		empupdate.setUsername(employee.getUsername());
		empupdate.setPassword(employee.getPassword());
		employeerepository.save(empupdate);
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

	@Override
	public Employee getEmployeeUnP(String username, String password) {
		
		return employeerepository.findByUsernameAndPassword(username, password);
	}
	

}
