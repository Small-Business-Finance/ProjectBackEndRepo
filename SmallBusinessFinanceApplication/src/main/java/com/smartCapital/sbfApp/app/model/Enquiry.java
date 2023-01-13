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
	private String customerName;
	private String companyName;
	private String typesOfBusiness;
	private String customerAddress;
	private String customerPancardNumber;
	private String companyPancardNumber;
	private Long mobileNumber;
	private Long alternateMobileNumber;
	private String emailId;
	private String itrStatus;
	private String enuiryStatus;
	private String registrationStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CibilScore cibilscore;	

}
