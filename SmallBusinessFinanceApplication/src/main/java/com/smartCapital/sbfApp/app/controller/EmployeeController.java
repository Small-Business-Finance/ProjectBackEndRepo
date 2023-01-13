package com.smartCapital.sbfApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartCapital.sbfApp.app.model.Employee;
import com.smartCapital.sbfApp.app.service.EmployeeServiceI;

@CrossOrigin("*")
@RequestMapping(value="/employeeapi")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceI esi;
	
	@PostMapping(value = "/saveemployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		esi.saveEmployee(employee);
		String s= "Employee Saved in Database!!";
		return new ResponseEntity<>(s,HttpStatus.CREATED);
		
	}
	@PutMapping(value = "/employee/{empId}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,@PathVariable("empId") Integer empId)
	{
		esi.updateEmployee(empId,employee);
		String s="Employee details updated successfully";
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	@DeleteMapping(value = "/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId)
	{
		System.out.println(empId);
		esi.deleteEmployee(empId);
		String s="The Employee is the Exit employee!!";
		return new ResponseEntity<>(s,HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/getallemp")
	public ResponseEntity<Iterable<Employee>> getEmployee()
	{
		Iterable<Employee> list=esi.getEmployee();
		return new ResponseEntity<Iterable<Employee>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getbyId")
	public Employee getEmployeebyId(@PathVariable("empId") Integer empId)
	{
		Employee employee=esi.getEmployeebyId(empId);
		return employee;
	}
}
