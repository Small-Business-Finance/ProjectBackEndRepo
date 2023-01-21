package com.smartCapital.sbfApp.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.repository.CustomerLoanDetailsRepository;
import com.smartCapital.sbfApp.app.service.CustomerLoanDetailsServiceI;

@Service
public class CustomerLoanServiceDetailsServiceImpl implements CustomerLoanDetailsServiceI {

	@Autowired
	CustomerLoanDetailsRepository csr;
	
	@Autowired
	CustomerApplicationFormRepository cr;
	
	@Override
	public void updateLoanDetails(CustomerLoanDetails ld, Integer applicationId) {
		CustomerApplicationForm ca=cr.findByApplicationId(applicationId);
		csr.save(ld);
		
	}

	

}
