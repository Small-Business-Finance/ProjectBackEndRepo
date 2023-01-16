package com.smartCapital.sbfApp.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto 
{
	private Integer empId;
	private String empName;
	private String empDateofBirth;
	private String empGender;
	private Double empSalary;
	private String empRole;
	private String empAddress;
	private long empMobileno;
	private String empEmailId;
	

}
