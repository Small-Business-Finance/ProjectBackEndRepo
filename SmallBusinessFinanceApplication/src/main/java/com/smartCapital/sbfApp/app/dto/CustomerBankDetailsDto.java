package com.smartCapital.sbfApp.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBankDetailsDto 
{
	
	private Integer bankId;
	private Long accountNumber;
	private String bankName;
	private Long ifscCode;
	private Integer branchCode;
	private String branchAddress;

}
