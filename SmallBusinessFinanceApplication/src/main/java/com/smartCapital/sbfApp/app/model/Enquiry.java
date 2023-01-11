package com.smartCapital.sbfApp.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enquiryId;
	private String companyName;
	private String companyRegistrationNumber;
	private String typesOfBusiness;
	private String companyAddress;
	private String customerName;
	private String companyPancardNumber;
	private String customerPancardNumber;
	private Long mobileNumber;
	private Long alternateMobileNumber;
	private String emailId;
	private String itrStatus;
	private String enuiryStatus;
	private String registrationStatus;
	@OneToOne(cascade = CascadeType.MERGE)
	private CibilScore cibilscore;
	
}
