package com.smartCapital.sbfApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;

@RestController
public class CustomerApplicationFormController {

	@Autowired
	CustomerApplicationFormServiceI csi;
	
	@PostMapping(value = "/application")
	public String saveApplicationForm(@RequestBody CustomerApplicationForm c)
	{
		csi.saveApplicationForm(c);
		return "data added successfully";
	}
	
	@GetMapping(value = "/applications")
	public List<CustomerApplicationForm> getApplications()
	{
		List<CustomerApplicationForm> list=csi.getApplications();
		return list;
	}
}
