package com.smartCapital.sbfApp.app.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.smartCapital.sbfApp.app.dto.EnquiryDto;
import com.smartCapital.sbfApp.app.model.Enquiry;

@Mapper
public interface EnquiryServiceMapper 
{
	EnquiryServiceMapper Instance=Mappers.getMapper(EnquiryServiceMapper.class);
	
//	public Enquiry toEnquiry(EnquiryDto enquirydto);
//	public EnquiryDto toEnquiryDto(Enquiry enquiry);
	public Iterable<Enquiry> toEnquiries(Iterable<EnquiryDto> enquirydtolist);
	public Iterable<EnquiryDto> toEnquiriesDto(Iterable<Enquiry> enquirylist);
	public Enquiry dtotoEnquiry(EnquiryDto edto);
	public EnquiryDto entityToDto(Enquiry enquiry);
	

}
