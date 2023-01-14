package com.smartCapital.sbfApp.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.smartCapital.sbfApp.app.model.CibilScore;


import com.smartCapital.sbfApp.app.model.Enquiry;

public interface CibilScoreRepository  extends CrudRepository<CibilScore, Integer> {

	@Transactional
	public	CibilScore findByCibilId(Integer id);

	
	

}
