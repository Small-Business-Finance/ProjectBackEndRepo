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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerApplicationForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicationId;
	private String applicationStatus;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CustomerDetails> customerDetails= new ArrayList<CustomerDetails>(); 
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerCompanyDetails customerCompanyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CompanyBankDetails companyBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PresentLoanDetails presentLoanDetails;
	
	
	
}
