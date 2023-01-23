package com.smartCapital.sbfApp.app.service;

import java.util.List;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.SanctionLetter;

public interface CustomerApplicationFormServiceI {

	void saveApplicationForm(CustomerApplicationForm c);

	List<CustomerApplicationForm> getApplications();

	void updateCustomer(CustomerApplicationForm cf, Integer applicationId);

	void deleteCustomer(Integer applicationId);

	CustomerApplicationForm getApplicationById(Integer applicationId);

	
}
