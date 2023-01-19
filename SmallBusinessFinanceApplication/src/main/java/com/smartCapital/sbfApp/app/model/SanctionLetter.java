package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SanctionLetter {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionedLoanId;
	private Integer applicationId;
	private String customerName;
	private Double expectedLoanAmount;
	private Double rateOfInterest;
	private Double expectedLoanTenure;
	private Double emiAmount;
	

}
