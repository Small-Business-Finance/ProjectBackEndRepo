package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBankDetails {

	@Id
	private double accountNo;
	private String bankName;
	private String ifscCode;
	private Integer branchCode;
	private String branchAddress;
}