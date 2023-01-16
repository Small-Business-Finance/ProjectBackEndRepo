package com.smartCapital.sbfApp.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDetailsDto 
{

	private Long aadharId;
	private String customerName;
	private String panCardNumber;
	private String dateOfBirth;
	private String gender;
	private Long mobileNumber;
	private String emailId;
	private String address;


}
