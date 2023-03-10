package com.smartCapital.sbfApp.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerLoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanId;	
	private Double expectedLoanAmount;
	private Double expectedLoanTenure;
	private Double rateOfInterest;
	private String loanStatus;
	private String loanDisbursedStatus;
	private Integer defaultorCount;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<EMITable> emitable=new ArrayList<EMITable>();
	
	 


}
