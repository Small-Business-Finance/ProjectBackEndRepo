package com.smartCapital.sbfApp.app.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.smartCapital.sbfApp.app.dto.EmployeeDto;
import com.smartCapital.sbfApp.app.model.Employee;

@Mapper
public interface EmployeeServiceIMapper 
{
	
	 EmployeeServiceIMapper Instance=Mappers.getMapper( EmployeeServiceIMapper.class);
	 
	 public Employee toEmployee(EmployeeDto employeedto);
	 public EmployeeDto toEmployeedto(Employee employee);
	 
	 public Iterable<Employee> toEmployees(Iterable<EmployeeDto> employeedtos);
	 public Iterable<EmployeeDto> toEmployeesDto(Iterable<Employee> employee);
}
