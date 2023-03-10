package com.smartCapital.sbfApp.app.service;

import com.smartCapital.sbfApp.app.model.Employee;

public interface EmployeeServiceI {

	public Employee saveEmployee(Employee employee);

	public void updateEmployee(Integer empId, Employee employee);

	public void deleteEmployee(Integer empId);

	public Iterable<Employee> getEmployee();

	public Employee getEmployeebyId(Integer empId);

	public Employee getEmployeeUnP(String username, String password);

}
