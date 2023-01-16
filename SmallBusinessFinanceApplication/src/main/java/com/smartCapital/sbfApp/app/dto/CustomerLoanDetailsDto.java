package com.smartCapital.sbfApp.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerLoanDetailsDto 
{

	private Integer loanId;
	private Double expectedLoanAmount;
	private Double expectedLoanTenure;
	private Double expectedEmiAmount;
	private String loanStatus;
	private String loanDisbursedStatus;
	

}
