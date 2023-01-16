package com.smartCapital.sbfApp.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SanctionLetterDto 
{
	
	private Integer sanctionedLoanId;
	private String customerName;
	private Double sanctionedLoanAmount;
	private Double sanctionedTenure;
	private Double emiAmount;
	private Long disbursedAmount;
	private Integer defaulterCount;


}
