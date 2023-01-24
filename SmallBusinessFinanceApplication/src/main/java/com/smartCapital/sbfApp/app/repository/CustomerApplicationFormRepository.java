package com.smartCapital.sbfApp.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.EMITable;

@Repository
public interface CustomerApplicationFormRepository extends JpaRepository<CustomerApplicationForm, Integer>
{
	public CustomerApplicationForm findByApplicationId(Integer applicationId);

	public List<CustomerApplicationForm> findByCustomerLoanDetails_DefaultorCountGreaterThan(int i);
	
}
