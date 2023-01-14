package com.smartCapital.sbfApp.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.model.CibilScore;
import com.smartCapital.sbfApp.app.model.Enquiry;
import com.smartCapital.sbfApp.app.service.EnquiryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api")



public class EnquiryController {

	@Autowired
	EnquiryService smartcapitalenquiryservice;
	@PostMapping(value = "/enquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody  Enquiry enquiry)
	{
		smartcapitalenquiryservice.saveEnquiry(enquiry);
		String s="Resource created successfully";
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/cibilscore")
	public ResponseEntity<String> saveCibilScore(@RequestBody  CibilScore cibilscore)
	{
		smartcapitalenquiryservice.saveCibilScore(cibilscore);
		String s="Resource created successfully";
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}

	
	
	@PutMapping(value = "/enquiry/{enquiryId}")
	public ResponseEntity<String> updateEnquiry(@RequestBody Enquiry enquiry,@PathVariable("enquiryId") Integer id)
	{
		smartcapitalenquiryservice.updateEnquiry(id,enquiry);
		String s="Resource updated successfully";
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/cibilscore/{cibilId}")
	public ResponseEntity<String> updateCibil(@RequestBody CibilScore cibilscore,@PathVariable("cibilId") Integer id)
	{
		smartcapitalenquiryservice.updateCibilScore(id,cibilscore);
		String s="Resource updated successfully";
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/enquiry/{enquiryId}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable("enquiryId") Integer id)
	{
		System.out.println(id);
		smartcapitalenquiryservice.deleteEnquiry(id);
		String s="There is not any content to show";
		return new ResponseEntity<>(s,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/enquiries")
	public ResponseEntity<Iterable<Enquiry>> getEnquiry()
	{
		Iterable<Enquiry> list=smartcapitalenquiryservice.getEnquiry();
		return new ResponseEntity<Iterable<Enquiry>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/enquiry/{enquiryId}")
	public Enquiry getEnquirybyID(@PathVariable("enquiryId") int id)
	{
		Enquiry enquiry=smartcapitalenquiryservice.getEnquirybyID(id);
		return enquiry;
	}
	
	
	@GetMapping(value = "/cibilscores")
	public ResponseEntity<Iterable<CibilScore>> getCibl()
	{
		Iterable<CibilScore> list=smartcapitalenquiryservice.getCibil();
		return new ResponseEntity<Iterable<CibilScore>>(list,HttpStatus.OK);
	}
	

	@GetMapping("/cibilscore/{cibilId}")
	public CibilScore getCibilbyID(@PathVariable("cibilId") int id)
	{
		CibilScore cibilscore=smartcapitalenquiryservice.getCibilbyID(id);
		return cibilscore;
		
	}
	@GetMapping("/cibil/getscore")
	public ResponseEntity<Double>getCIBILScore()
	{
		int min=600;
		int max=900;
		double a= Math.random()*(max-min+1)+min;
		
		return new ResponseEntity<Double>(a,HttpStatus.OK);


	}
}
	

