package com.smartCapital.sbfApp.app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDto 
{
	
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
	private String enquiryStatus;
	private String registrationStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CibilScoreDto cibilscore;	

}
