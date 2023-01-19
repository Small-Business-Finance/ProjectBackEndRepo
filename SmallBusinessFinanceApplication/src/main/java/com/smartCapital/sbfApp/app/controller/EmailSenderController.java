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
			return "Email not sent";
		}
		return "Email Sent";
	}
	@PostMapping(value="/send")
	public String sendEmailWithAttachment(@RequestBody EmailSender e)
	{
		e.setFromEmail(fromEmail);
		
		try {
		
			esi.sendEmailWithAttachment(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return "Email not Sent!!!";
		}
		return "Email Sent!!";
	}
	
	
	@PostMapping(value = "/mail",consumes = MediaType.ALL_VALUE)
	public void sendSanctionMail(@RequestPart("toEmail") String toemail) throws Exception
	{
		EmailSender em= new EmailSender();
		SanctionLetter sl=new SanctionLetter();
		ObjectMapper om = new ObjectMapper();
		EmailSender value = om.readValue(toemail,EmailSender.class);
		em.setToEmail(value.getToEmail());
		em.setSubject("Loan Sanction Letter");
		em.setMessage("Dear"+sl.getCustomerName()+"\n"+"We are happy to inform you that,"+"\n"+"your business loan for the amount"+sl.getExpectedLoanAmount()+
				"has been sanctioned.Please read terms and conditions carefully for the same");
		
		System.out.println(toemail);
		System.out.println(value.getToEmail());
		esi.sendSanctionMail(em.getToEmail(),em);
	}
	
}
