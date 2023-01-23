package com.smartCapital.sbfApp.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;

@Repository
public interface CustomerApplicationFormRepository extends JpaRepository<CustomerApplicationForm, Integer>
{
	public CustomerApplicationForm findByApplicationId(Integer applicationId);
	
}
