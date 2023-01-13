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
	private Long registrationNumber;
	private String companyName;
	private String companyOwnerName;
	private String typeOfBusiness;
	private String PanCardNumber;
	private Double companyTurnover;
	private Long telephoneNo;
	private Integer faxNumber;

}
