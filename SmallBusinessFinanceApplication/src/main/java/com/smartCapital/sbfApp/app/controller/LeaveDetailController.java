package com.smartCapital.sbfApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.model.Enquiry;
import com.smartCapital.sbfApp.app.model.LeaveDetails;
import com.smartCapital.sbfApp.app.service.LeaveDetailService;

@CrossOrigin("*")
@RequestMapping(value="/leaveapi")
@RestController
public class LeaveDetailController {
	
	@Autowired
	LeaveDetailService leavedetailservice;
	
	@PostMapping(value = "/leavedetail")
	public ResponseEntity<String> saveLeaveDetail(@RequestBody  LeaveDetails leavedetails)
	{
		leavedetailservice.saveLeaveDetail(leavedetails);
		String s="Resource created successfully";
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}

	
	@PutMapping(value = "/leavedetail/{leaveAppId}")
	public ResponseEntity<String> updateLeaveDetail(@RequestBody LeaveDetails leavedetails,@PathVariable("leaveAppId") Integer id)
	{
		leavedetailservice.updateLeaveDetail(id,leavedetails);
		String s="Resource updated successfully";
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	
	
}
