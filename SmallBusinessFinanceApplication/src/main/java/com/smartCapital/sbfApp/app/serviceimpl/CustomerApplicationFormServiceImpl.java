package com.smartCapital.sbfApp.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCapital.sbfApp.app.exceptionhandling.FindByApplicationIdException;
import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerBankDetails;
import com.smartCapital.sbfApp.app.model.CustomerCompanyDetails;
import com.smartCapital.sbfApp.app.model.CustomerDetails;
import com.smartCapital.sbfApp.app.model.CustomerDocuments;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.GuarantorDetails;
import com.smartCapital.sbfApp.app.model.PreviousLoanDetails;
import com.smartCapital.sbfApp.app.model.SanctionLetter;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository2;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;

@Service
public class CustomerApplicationFormServiceImpl implements CustomerApplicationFormServiceI
{
	@Autowired
	CustomerApplicationFormRepository cr;
	
	@Autowired
	CustomerApplicationFormRepository2 crr;

	@Override
	public void saveApplicationForm(CustomerApplicationForm c) {
		
		cr.save(c);
	}

	@Override
	public List<CustomerApplicationForm> getApplications() {
	
		return cr.findAll();
	}

	@Override
	public void updateCustomer(CustomerApplicationForm cf, Integer applicationId) {
		
		CustomerApplicationForm caf=cr.findByApplicationId(applicationId);
		cf.setCustomerDocuments(caf.getCustomerDocuments());
//		System.out.println(cf.getApplicationStatus());
//		caf.setApplicationStatus(cf.getApplicationStatus());
		cr.save(cf);	
		
	}

	@Override
	public void deleteCustomer(Integer applicationId) {
		cr.deleteById(applicationId);
		
	}
	
//	@Override
//	public CustomerApplicationForm getApplicationById(Integer applicationId)
//	{
//		return cr.findByApplicationId(applicationId);
//	}
	
	@Override
	public CustomerApplicationForm getApplicationById(Integer applicationId) throws FindByApplicationIdException
	{
		
		Optional<CustomerApplicationForm> cf =crr.findByApplicationId(applicationId);
		if(cf.isPresent())
		{
			CustomerApplicationForm c = cf.get();
			return c;	
		}
		else
		{
			throw new FindByApplicationIdException("No Customer found with this Id..");
		}
		
	 }
}


	

