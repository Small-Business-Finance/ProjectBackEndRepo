package com.smartCapital.sbfApp.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartCapital.sbfApp.app.model.CibilScore;
import com.smartCapital.sbfApp.app.model.Enquiry;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry, Integer> {

	@Transactional
	public Enquiry findByEnquiryId(Integer id);

	
	
}
