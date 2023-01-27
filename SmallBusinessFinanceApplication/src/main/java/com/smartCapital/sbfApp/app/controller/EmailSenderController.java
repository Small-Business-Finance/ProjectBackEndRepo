package com.smartCapital.sbfApp.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.smartCapital.sbfApp.app.model.CustomerDetails;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.Enquiry;
import com.smartCapital.sbfApp.app.model.MailResponse;
import com.smartCapital.sbfApp.app.model.SanctionLetter;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceI;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceIMapper;

import freemarker.template.Configuration;
import freemarker.template.Template;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/emailsenderapi")
public class EmailSenderController {

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Autowired
	EmailSenderServiceI esi;

	@Autowired
	private Configuration config;

	// Post API
	@PostMapping(value = "/emailsend")
	public String sendEmail(@RequestBody EmailSender e) {
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

	@PostMapping(value = "/send")
	public String sendEmailWithAttachment(@RequestBody EmailSender e) {
		e.setFromEmail(fromEmail);

		try {

			esi.sendEmailWithAttachment(e);
		} catch (Exception e1) {

			return "Email not Sent!!!";
		}
		return "Email Sent!!";
	}

	@PostMapping(value = "/sanction")
	public void sendSanctionMail(@RequestBody SanctionLetter sl) throws Exception {
		EmailSender em = new EmailSender();
		em.setFromEmail(fromEmail);
		try {
				Template t=null;
				em.setToEmail(sl.getEmailId());
				System.out.println(sl.getApplicationId());
				em.setSubject("Loan Sanction Letter");
				t=config.getTemplate("emailsanction.ftl");
			
		Map<String, Object> mode = new HashMap<>();
		mode.put("name", sl.getCustomerName());
		//mode.put("amount",sl.getExpectedLoanAmount());
		esi.sendSanctionMail(em, mode,t);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping(value = "/mail")
	public void sendMultipleMail(@RequestBody CustomerApplicationForm cf) throws Exception {
		EmailSender em = new EmailSender();
		em.setFromEmail(fromEmail);
		em.setToEmail(cf.getCustomerDetails().getEmailId());
		Template t=null;
		
		try {
			
		if(cf.getApplicationStatus().equals("Rejected"))
		{
			System.out.println(cf.getApplicationStatus());
			System.out.println(cf.getApplicationId());
			System.out.println(cf.getCustomerDetails().getEmailId());
			em.setSubject("Loan Rejection Letter");
			t=config.getTemplate("emailrejection.ftl");
		}
		
		if(cf.getApplicationStatus().equals("Sanctioned"))
		{
			System.out.println(cf.getApplicationId());
			System.out.println(cf.getCustomerDetails().getEmailId());
			em.setSubject("Loan Disbursed Letter");
			t=config.getTemplate("emaildisbursement.ftl");
		}
		
//		//if()
//		{
//			System.out.println(cf.getApplicationId());
//			System.out.println(cf.getCustomerDetails().getEmailId());
//			em.setSubject("EMI Notice");
//			t=config.getTemplate("emailnotice.ftl");
//		}
		
		Map<String, Object> mode = new HashMap<>();
		mode.put("name", cf.getCustomerDetails().getCustomerName());
		//mode.put("amount",sl.getExpectedLoanAmount());
		
		esi.sendMultipleMail(em,mode,t);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@PostMapping(value = "/lowcibil")
	public void sendCibilMail(@RequestBody Enquiry eq) throws Exception {
		EmailSender em = new EmailSender();
		em.setFromEmail(fromEmail);
		try {
				Template t=null;
				em.setToEmail(eq.getEmailId());
				System.out.println(eq.getEmailId());
				System.out.println(eq.getCibilscore().getCibilRemark());
				em.setSubject("Loan Application Rejection Due to Low Cibil");
				t=config.getTemplate("emaillowcibil.ftl");
			
		Map<String, Object> mode = new HashMap<>();
		mode.put("name",eq.getCustomerName());
		//mode.put("amount",sl.getExpectedLoanAmount());
		esi.sendCibilMail(em, mode,t);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

}
}
