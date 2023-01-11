package com.smartCapital.sbfApp.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sanction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionedLoanId;
	private  Double sanctionedLoanAmount;
	private Double sanctionedTenure;
	private Double emi;
	private Long disbursedAmount;
	private String companyName;
	private Long companyRegistrationNo;
	private Integer defaultorCount;

}
