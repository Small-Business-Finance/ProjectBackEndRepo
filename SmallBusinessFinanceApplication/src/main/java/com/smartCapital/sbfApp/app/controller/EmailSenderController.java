package com.smartCapital.sbfApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceI;

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
}
