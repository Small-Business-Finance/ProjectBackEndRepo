package com.smartCapital.sbfApp.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCapital.sbfApp.app.model.CibilScore;
import com.smartCapital.sbfApp.app.model.Enquiry;
import com.smartCapital.sbfApp.app.repository.CibilScoreRepository;
import com.smartCapital.sbfApp.app.repository.EnquiryRepository;
import com.smartCapital.sbfApp.app.service.EnquiryService;


@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	EnquiryRepository enquiryrepository;
	CibilScoreRepository cibilscorerepository;
	@Override
	public void saveEnquiry(Enquiry enquiry) {
		enquiryrepository.save(enquiry);
		
	}
	@Override
	public void saveCibilScore(CibilScore cibilscore) {
	
		cibilscorerepository.save(cibilscore);
	}
	
	@Override
	public void updateEnquiry(Integer id, Enquiry enquiry) {
	
		Enquiry enqiryupd=enquiryrepository.findByEnquiryId(id);
		
		enqiryupd.setEnquiryId(enquiry.getEnquiryId());
		enqiryupd.setCompanyName(enquiry.getCompanyName());
		enqiryupd.setCompanyRegistrationNumber(enquiry.getCompanyRegistrationNumber());
		enqiryupd.setTypesOfBusiness(enquiry.getTypesOfBusiness());
		enqiryupd.setCompanyAddress(enquiry.getCompanyAddress());
		enqiryupd.setCustomerName(enquiry.getCompanyName());
		enqiryupd.setCompanyPancardNumber(enquiry.getCompanyPancardNumber());
		enqiryupd.setCustomerPancardNumber(enquiry.getCustomerPancardNumber());
		enqiryupd.setMobileNumber(enquiry.getMobileNumber());
		enqiryupd.setAlternateMobileNumber(enquiry.getAlternateMobileNumber());
		enqiryupd.setEmailId(enquiry.getEmailId());
		enqiryupd.setItrStatus(enquiry.getItrStatus());
		enqiryupd.setEnuiryStatus(enquiry.getEnuiryStatus());
		enqiryupd.setRegistrationStatus(enquiry.getRegistrationStatus());
		enqiryupd.setCibilscore(enquiry.getCibilscore());
		enquiryrepository.save(enqiryupd);
		
	}
	@Override
	public void updateCibilScore(Integer id, CibilScore cibilscore) {
		CibilScore cibilscoreupd= cibilscorerepository.findByCibilId(id);
		cibilscoreupd.setCibilId(cibilscore.getCibilId());
		cibilscoreupd.setCibilScore(cibilscore.getCibilScore());
		cibilscoreupd.setCibilRemark(cibilscore.getCibilRemark());
		cibilscorerepository.save(cibilscoreupd);
		
	}
	@Override
	public void deleteEnquiry(Integer id) {
		enquiryrepository.deleteById(id);
		
	}
	@Override
	public Iterable<Enquiry> getEnquiry() {
		
		return enquiryrepository.findAll();
	}
	@Override
	public Enquiry getEnquirybyID(int id) {
		
		return enquiryrepository.findByEnquiryId(id);
	}
	@Override
	public Iterable<CibilScore> getCibil() {
		
		return cibilscorerepository.findAll();
	}
	@Override
	public CibilScore getCibilbyID(int id) {
		
		return cibilscorerepository.findByCibilId(id);
	}
	

}
