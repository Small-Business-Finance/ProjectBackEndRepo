package com.smartCapital.sbfApp.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartCapital.sbfApp.app.dto.EmailSenderDto;
import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.SanctionLetter;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceI;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceIMapper;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/emailsenderapi")
public class EmailSenderController {

	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Autowired
	EmailSenderServiceI esi;
	
	
	//Post API
	@PostMapping(value="/emailsend")
	public String sendEmail(@RequestBody EmailSender e)
	{
		e.setFromEmail(fromEmail);
		try {
			
			esi.sendEmail(e);
		} catch (Exception e2) {
			System.out.println("Email Not Sent");
			e2.printStackTrace();
			return "Email not sent";
		}
		System.out.println("Email Sent");
		return "Email Sent";
	}
	@PostMapping(value="/send")
	public String sendEmailWithAttachment(@RequestBody EmailSender e)
	{
		e.setFromEmail(fromEmail);
		
		try {
		
			esi.sendEmailWithAttachment(e);
		} catch (Exception e1) {
		
			return "Email not Sent!!!";
		}
		return "Email Sent!!";
	}
	
	
	@PostMapping(value = "/sanction")
	public void sendSanctionMail(@RequestBody SanctionLetter sl) throws Exception
	{
		EmailSender em=new EmailSender();
		em.setFromEmail(fromEmail);
		em.setToEmail(sl.getEmailId());
		em.setSubject("Loan Sanction Letter");
		em.setMessage("Dear "+sl.getCustomerName()+"\n"+"We are happy to inform you that,"+"\n"+"your business loan for the amount "+sl.getExpectedLoanAmount()+
				" has been sanctioned.Please read terms and conditions carefully for the same.");
		
		esi.sendSanctionMail(em);
	}
	
	@PostMapping(value = "/rejection")
	public void sendRejectionMail(@RequestBody CustomerApplicationForm cf) throws Exception
	{
		EmailSender em=new EmailSender();
		em.setFromEmail(fromEmail);
		em.setToEmail(cf.getCustomerDetails().getEmailId());
		em.setSubject("Loan Rejection Letter");
		em.setMessage("Dear "+cf.getCustomerDetails().getCustomerName()+"\n\n"+"After going through your application,We are sorry to inform you that,"+"\n"+"your business loan application for the amount "+cf.getCustomerLoanDetails().getExpectedLoanAmount()+
				" has been rejected");
		
		esi.sendRejectionMail(em);
	}
	
	
}