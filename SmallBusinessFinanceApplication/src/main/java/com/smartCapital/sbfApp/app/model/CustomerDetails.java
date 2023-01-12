package com.smartCapital.sbfApp.app.model;

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
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aadharId;
	private String customerName;
	private String emailId;
	private Long mobileNo;
	private Long panCardNumber;
	private String dateOfBirth;
	private String gender;

}
