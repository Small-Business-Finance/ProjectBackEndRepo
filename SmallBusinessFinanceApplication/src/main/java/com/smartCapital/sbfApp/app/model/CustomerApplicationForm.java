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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerApplicationForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicationId;
	private String applicationStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerDetails customerDetails; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private CompanyContactInfo customerContactInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerCompanyDetails customerCompanyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails companyBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PresentLoanDetails presentLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CompanyDocuments companyDocuments;
		
}
