package com.smartCapital.sbfApp.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	private Integer companyRegistrationNo;
	private String companyName;
	private String typeOfBusiness;
	private String companyPANCard;
	private double companyTurnover;
	private String applicationStatus;
	@OneToOne(cascade=CascadeType.ALL)
	private companyBankDetails companyBankDetails; 
}
