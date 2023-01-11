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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PreviousLoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer previousLoanDetailsId;
	private Double loanAmount;
	private Double loanTenure;
	private Double paidAmount;
	private Double remainingAmount;
	private Integer defaulterCount;	
	private String bankName;
	
	


}
