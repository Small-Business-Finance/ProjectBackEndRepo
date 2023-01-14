package com.smartCapital.sbfApp.app.dto;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerApplicationFormDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicationId;
	private String applicationStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerDetailsDto customerDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerCompanyDetailsDto customerCompanyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetailsDto customerBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetailsDto guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetailsDto previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerLoanDetailsDto customerLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocumentsDto customerDocuments;
		
}
