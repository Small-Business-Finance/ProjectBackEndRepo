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
@Entity
public class CustomerDetailsDto {

	@Id
	private Long aadharId;
	private String customerName;
	private String panCardNumber;
	private String dateOfBirth;
	private String gender;
	private Long mobileNumber;
	private String emailId;
	private String address;

}
