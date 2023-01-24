package com.smartCapital.sbfApp.app.service;

import java.util.List;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.EMITable;

public interface CustomerLoanDetailsServiceI {

	void updateLoanDetails( Integer applicationId);

	List<CustomerApplicationForm> getDefaulter();

	String updateemi(EMITable et);

}
