package com.smartCapital.sbfApp.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartCapital.sbfApp.app.model.CustomerDocuments;
import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerBankDetails;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;

@RestController
public class CustomerApplicationFormController {

	@Autowired
	CustomerApplicationFormServiceI csi;
	
//	@PostMapping(value = "/application")
//	public String saveApplicationForm(@RequestBody CustomerApplicationForm c)
//	{
//		csi.saveApplicationForm(c);
//		return "data added successfully";
//	}
	
	@PostMapping(value = "/application")
	public String saveApplicationForm(@RequestPart("document") MultipartFile file1,
			@RequestPart("applicationForm")String application) throws IOException
	{

		ObjectMapper om=new ObjectMapper();
		
		CustomerApplicationForm cmf=om.readValue(application,CustomerApplicationForm.class);
		
		CustomerApplicationForm cf=new CustomerApplicationForm();
		cf.setApplicationStatus(cmf.getApplicationStatus());
		
		CustomerBankDetails cb=new CustomerBankDetails();
		cb.setAccountNumber(cmf.getCustomerBankDetails().getAccountNumber());
		cb.setBankName(cmf.getCustomerBankDetails().getBankName());
		cb.setIfscCode(cmf.getCustomerBankDetails().getIfscCode());
		cb.setBranchCode(cmf.getCustomerBankDetails().getBranchCode());
		cb.setBranchAddress(cmf.getCustomerBankDetails().getBranchAddress());
		cf.setCustomerBankDetails(cb);
		
		CustomerDocuments cd=new CustomerDocuments();
		cd.setAoa(file1.getBytes());
		cf.setCustomerDocuments(cd);
		
		csi.saveApplicationForm(cf);
		
		

		return "data added successfully";
	}
	
	@GetMapping(value = "/applications")
	public List<CustomerApplicationForm> getApplications()
	{
		List<CustomerApplicationForm> list=csi.getApplications();
		return list;
	}
}
