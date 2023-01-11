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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PresentLoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanDetailsId;
	private Double expectedLoanAmount;
	 private Double expectedLoanTenure;
private Double	expectedEmiAmount;
	private String loanStatus;
	private String loanDisbursedStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private companyBankDetails companyBankDetails; 


}
