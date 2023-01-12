package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long companyRegistrationNo;
	private String companyName;
	private String typeOfBusiness;
	private String companyPanCardNumber;
	private Double companyTurnover;

}
