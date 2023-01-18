package com.smartCapital.sbfApp.app.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartCapital.sbfApp.app.model.CustomerDocuments;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.GuarantorDetails;
import com.smartCapital.sbfApp.app.model.PreviousLoanDetails;
import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerBankDetails;
import com.smartCapital.sbfApp.app.model.CustomerCompanyDetails;
import com.smartCapital.sbfApp.app.model.CustomerDetails;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/customerapi")
public class CustomerApplicationFormController {

	@Autowired
	CustomerApplicationFormServiceI csi;
	
//	@PostMapping(value = "/application")
//	public String saveApplicationForm(@RequestBody CustomerApplicationForm c)
//	{
//		csi.saveApplicationForm(c);
//		return "data added successfully";
//	}
	
	@PostMapping(value = "/application",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveApplicationForm(@RequestPart("itrReturns") MultipartFile file1,
			@RequestPart("pancard") MultipartFile file2,
			@RequestPart("moa") MultipartFile file3,
			@RequestPart("aoa") MultipartFile file4,
			@RequestPart("auditReport") MultipartFile file5,
			@RequestPart("tan") MultipartFile file6,
			@RequestPart("msmeCertificate") MultipartFile file7,
			@RequestPart("applicationForm")String application) throws IOException
	{

		ObjectMapper om=new ObjectMapper();
		
		CustomerApplicationForm cmf=om.readValue(application,CustomerApplicationForm.class);
		
		CustomerApplicationForm cf=new CustomerApplicationForm();
		cf.setApplicationStatus(cmf.getApplicationStatus());
		
		CustomerDetails cdt=new CustomerDetails();
		cdt.setAadharId(cmf.getCustomerDetails().getAadharId());
		cdt.setCustomerName(cmf.getCustomerDetails().getCustomerName());
		cdt.setEmailId(cmf.getCustomerDetails().getEmailId());
		cdt.setMobileNumber(cmf.getCustomerDetails().getMobileNumber());
		cdt.setPanCardNumber(cmf.getCustomerDetails().getPanCardNumber());
		cdt.setDateOfBirth(cmf.getCustomerDetails().getDateOfBirth());
		cdt.setGender(cmf.getCustomerDetails().getGender());
		cdt.setAddress(cmf.getCustomerDetails().getAddress());
		cf.setCustomerDetails(cdt);
	
		CustomerCompanyDetails ccd=new CustomerCompanyDetails();
		ccd.setRegistrationNumber(cmf.getCustomerCompanyDetails().getRegistrationNumber());
		ccd.setCompanyName(cmf.getCustomerCompanyDetails().getCompanyName());
		ccd.setCompanyOwnerName(cmf.getCustomerCompanyDetails().getCompanyOwnerName());
		ccd.setTypeOfBusiness(cmf.getCustomerCompanyDetails().getTypeOfBusiness());
		ccd.setPanCardNumber(cmf.getCustomerCompanyDetails().getPanCardNumber());
		ccd.setCompanyTurnover(cmf.getCustomerCompanyDetails().getCompanyTurnover());
		ccd.setTelephoneNo(cmf.getCustomerCompanyDetails().getTelephoneNo());
		ccd.setFaxNumber(cmf.getCustomerCompanyDetails().getFaxNumber());
		cf.setCustomerCompanyDetails(ccd);
		
		CustomerBankDetails cb=new CustomerBankDetails();
		cb.setAccountNumber(cmf.getCustomerBankDetails().getAccountNumber());
		cb.setBankName(cmf.getCustomerBankDetails().getBankName());
		cb.setIfscCode(cmf.getCustomerBankDetails().getIfscCode());
		cb.setBranchCode(cmf.getCustomerBankDetails().getBranchCode());
		cb.setBranchAddress(cmf.getCustomerBankDetails().getBranchAddress());
		cf.setCustomerBankDetails(cb);
		
		GuarantorDetails gd=new GuarantorDetails();
		gd.setGuarantorName(cmf.getGuarantorDetails().getGuarantorName());
		gd.setGuarantorPanCardNumber(cmf.getGuarantorDetails().getGuarantorPanCardNumber());
		gd.setRelation(cmf.getGuarantorDetails().getRelation());
		gd.setMobileNumber(cmf.getGuarantorDetails().getMobileNumber());
		gd.setOccupation(cmf.getGuarantorDetails().getOccupation());
		cf.setGuarantorDetails(gd);
		
		PreviousLoanDetails pld=new PreviousLoanDetails();
		pld.setPreviousLoanId(cmf.getPreviousLoanDetails().getPreviousLoanId());
		pld.setLoanAmount(cmf.getPreviousLoanDetails().getLoanAmount());
		pld.setLoanTenure(cmf.getPreviousLoanDetails().getLoanTenure());
		pld.setPaidAmount(cmf.getPreviousLoanDetails().getPaidAmount());
		pld.setRemainingAmount(cmf.getPreviousLoanDetails().getRemainingAmount());
		pld.setDefaulterCount(cmf.getPreviousLoanDetails().getDefaulterCount());
		pld.setBankName(cmf.getPreviousLoanDetails().getBankName());
		cf.setPreviousLoanDetails(pld);
			
		CustomerLoanDetails cld=new CustomerLoanDetails();	
		cld.setExpectedLoanAmount(cmf.getCustomerLoanDetails().getExpectedLoanAmount());
		cld.setExpectedLoanTenure(cmf.getCustomerLoanDetails().getExpectedLoanTenure());
		cld.setExpectedEmiAmount(cmf.getCustomerLoanDetails().getExpectedEmiAmount());
		cld.setRateOfInterest(cmf.getCustomerLoanDetails().getRateOfInterest());
		cld.setLoanStatus(cmf.getCustomerLoanDetails().getLoanStatus());
		cld.setLoanDisbursedStatus(cmf.getCustomerLoanDetails().getLoanDisbursedStatus());
		cf.setCustomerLoanDetails(cld);
		
		CustomerDocuments cd=new CustomerDocuments();
		cd.setItrReturns(file1.getBytes());
		cd.setPancard(file2.getBytes());
		cd.setMoa(file3.getBytes());
		cd.setAoa(file4.getBytes());
		cd.setAuditReport(file5.getBytes());
		cd.setTan(file6.getBytes());
		cd.setMsmeCertificate(file7.getBytes());
		cf.setCustomerDocuments(cd);
		
		csi.saveApplicationForm(cf);
		
		String s="Resource created successfully";

		return new ResponseEntity<String>(s,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/applications")
	public ResponseEntity<Iterable<CustomerApplicationForm>> getApplications()
	{
		System.out.println("get......");
		Iterable<CustomerApplicationForm> list=csi.getApplications();
		return new ResponseEntity<Iterable<CustomerApplicationForm>>(list,HttpStatus.OK);
	}
	

	
	@GetMapping(value = "/applications/{applicationId}")
	public ResponseEntity<CustomerApplicationForm> getApplicationById(@PathVariable Integer applicationId)
	{
		CustomerApplicationForm list=csi.getApplicationById(applicationId);
		return new ResponseEntity<CustomerApplicationForm>(list,HttpStatus.OK);
	}
	
	
	
	@PutMapping(value = "/application/{applicationId}")
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerApplicationForm cf,@PathVariable Integer applicationId)
	{
		csi.updateCustomer(cf,applicationId);
		String s="updated";
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/application/{applicationId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer applicationId)
	{
		csi.deleteCustomer(applicationId);
		String s="record deleted";
		return new ResponseEntity<String>(s,HttpStatus.NO_CONTENT);
	}
}
