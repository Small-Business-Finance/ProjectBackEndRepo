package com.smartCapital.sbfApp.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;

@Service
public class CustomerApplicationFormServiceImpl implements CustomerApplicationFormServiceI
{
	@Autowired
	CustomerApplicationFormRepository cr;

	@Override
	public void saveApplicationForm(CustomerApplicationForm c) {
		
		cr.save(c);
	}

	@Override
	public List<CustomerApplicationForm> getApplications() {
	
		return cr.findAll();
	}

	
}
