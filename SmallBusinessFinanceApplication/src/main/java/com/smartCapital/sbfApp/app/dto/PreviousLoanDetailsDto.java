package com.smartCapital.sbfApp.app.dto;


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
public class PreviousLoanDetailsDto {
	
	@Id
	private Integer previousLoanId;
	private Double loanAmount;
	private Double loanTenure;
	private Double paidAmount;
	private Double remainingAmount;
	private Integer defaulterCount;	
	private String bankName;
	
	


}
