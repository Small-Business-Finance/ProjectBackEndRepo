package com.smartCapital.sbfApp.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;

@Repository
public interface CustomerApplicationFormRepository extends JpaRepository<CustomerApplicationForm, Integer>
{

}
