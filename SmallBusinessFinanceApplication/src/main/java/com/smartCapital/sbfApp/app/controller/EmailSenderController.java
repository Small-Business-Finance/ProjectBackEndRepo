package com.smartCapital.sbfApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.dto.EmailSenderDto;
import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.SanctionLetter;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceI;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceIMapper;


@RestController
@RequestMapping(value="/emailsenderapi")
public class EmailSenderController {

	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Autowired
	EmailSenderServiceI esi;
	
	public EmailSenderServiceIMapper emailsenderserviceimapper;
	
	//Post API
	@PostMapping(value="/emailsend")
	public String sendEmail(@RequestBody EmailSenderDto edto)
	{
		edto.setFromEmail(fromEmail);
		try {
			//EmailSender e=emailsenderserviceimapper.Instance.toEmailSender(edto);
			//esi.sendEmail(edto);
		} catch (Exception e2) {
			return "Email not sent";
		}
		return "Email Sent";
	}
	@PostMapping(value="/send")
	public String sendEmailWithAttachment(@RequestBody EmailSenderDto edto)
	{
		//e.setFromEmail(fromEmail);
		
		try {
			EmailSender e=emailsenderserviceimapper.Instance.toEmailSender(edto);
			esi.sendEmailWithAttachment(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return "Email not Sent!!!";
		}
		return "Email Sent!!";
	}
	
}
