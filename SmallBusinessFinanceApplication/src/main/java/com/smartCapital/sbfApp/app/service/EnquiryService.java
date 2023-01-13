package com.smartCapital.sbfApp.app.service;

import com.smartCapital.sbfApp.app.model.CibilScore;
import com.smartCapital.sbfApp.app.model.Enquiry;

public interface EnquiryService {

	void saveEnquiry(Enquiry enquiry);


	void updateEnquiry(Integer id, Enquiry enquiry);
	void saveCibilScore(CibilScore cibilscore);

	void updateCibilScore(Integer id, CibilScore cibilscore);

	void deleteEnquiry(Integer id);

	Iterable<Enquiry> getEnquiry();

	Enquiry getEnquirybyID(int id);

	Iterable<CibilScore> getCibil();

	CibilScore getCibilbyID(int id);
	



}
