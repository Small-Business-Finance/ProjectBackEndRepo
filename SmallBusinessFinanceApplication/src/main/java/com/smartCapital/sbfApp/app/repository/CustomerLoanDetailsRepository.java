package com.smartCapital.sbfApp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.EMITable;
import com.smartCapital.sbfApp.app.model.Employee;

@Repository
public interface CustomerLoanDetailsRepository extends JpaRepository<CustomerLoanDetails, Integer>{

	CustomerLoanDetails findByEmitable_EmiDetailsId(Integer EmiDetailsId);
}
