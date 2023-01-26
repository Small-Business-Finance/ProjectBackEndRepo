package com.smartCapital.sbfApp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;

@Repository
public interface CustomerApplicationFormRepository2 extends JpaRepository<CustomerApplicationForm, Integer>{

	Optional<CustomerApplicationForm> findByApplicationId(Integer applicationId);

}
