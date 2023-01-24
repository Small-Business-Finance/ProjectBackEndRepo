package com.smartCapital.sbfApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;
import com.smartCapital.sbfApp.app.service.CustomerLoanDetailsServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/loanapi123")
public class CustomerLoanDetailsController {

	@Autowired
	CustomerLoanDetailsServiceI cs;
	
	
//	@PutMapping(value = "/application/{applicationId}")
//	public ResponseEntity<String> updateLoanDetails(@PathVariable Integer applicationId,Integer id)
//	{
//		
//		cs.updateLoanDetails(applicationId);
//		String s="updated";
//		System.out.println("Heelllooooooooo");
//		return new ResponseEntity<String>(s,HttpStatus.OK);
//	}
	
//	@GetMapping	(value = "/getbyloandetailsId/{applicationId}")
//	public List<CustomerLoanDetails> getLoanDetailbyId(@PathVariable("applicationId") Integer applicationId)
//	{
//		List<CustomerLoanDetails> loandetails=cs.getLoanDetailbyId(applicationId);
//		return loandetails;
//	}
	
	@PutMapping(value = "/application/{applicationId}")
	public ResponseEntity<String> updateLoanDetails(@PathVariable Integer applicationId,Integer id)
	{
		
		cs.updateLoanDetails(applicationId);
		String s="updated";
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
	@GetMapping(value = "/defaulterlist")
	public List<CustomerApplicationForm> defaulter(){
		return cs.getDefaulter();
	}

}
