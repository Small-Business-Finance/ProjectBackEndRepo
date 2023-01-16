package com.smartCapital.sbfApp.app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.smartCapital.sbfApp.app.model.CustomerBankDetails;
import com.smartCapital.sbfApp.app.model.CustomerCompanyDetails;
import com.smartCapital.sbfApp.app.model.CustomerDetails;
import com.smartCapital.sbfApp.app.model.CustomerDocuments;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.GuarantorDetails;
import com.smartCapital.sbfApp.app.model.PreviousLoanDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerApplicationFormDto 
{

	
	private Integer applicationId;
	private String applicationStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerDetailsDto customerDetailsDto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerCompanyDetailsDto customerCompanyDetailsDto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetailsDto customerBankDetailsDto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetailsDto guarantorDetailsDto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetailsDto previousLoanDetailsDto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerLoanDetailsDto customerLoanDetailsDto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocumentsDto customerDocumentsDto;
		

}
