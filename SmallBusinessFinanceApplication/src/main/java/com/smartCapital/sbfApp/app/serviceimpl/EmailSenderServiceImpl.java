package com.smartCapital.sbfApp.app.serviceimpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.SanctionLetter;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceI;

@Component
public class EmailSenderServiceImpl implements EmailSenderServiceI{

	@Autowired
	JavaMailSender sender;
	
	@Autowired
	CustomerApplicationFormRepository cr;
	
	@Override
	public void sendEmail(EmailSender e) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(e.getToEmail());
		message.setFrom(e.getFromEmail());
		message.setText(e.getMessage());
		message.setSubject(e.getSubject());
		
		sender.send(message);
	}

	@Override
	public void sendEmailWithAttachment(EmailSender e) {
		MimeMessage message = sender.createMimeMessage();
		
		   try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(e.getToEmail());
			helper.setFrom(e.getFromEmail());
			helper.setText(e.getMessage());
			helper.setSubject(e.getSubject());
			
			FileSystemResource resource=new FileSystemResource("D:\\FileUploadinspringbootrestapi.pdf");
			
			helper.addAttachment(resource.getFilename(), resource);
			
			sender.send(message);
			
			}catch (Exception e1) {
				e1.printStackTrace();
		     }
		
	}

	@Override
	public void sendSanctionMail(EmailSender em) throws Exception 
	{
		
			MimeMessage message=sender.createMimeMessage();
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message,true);
				helper.setTo(em.getToEmail());
				helper.setText(em.getMessage()+"\nPlease visit our office for any Query or contact us at www.sfc.com\nThank You !\n\nRegards,\nSFC family.");
				helper.setSubject("Loan Sanction Letter");
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
			
			sender.send(message);
			System.out.println("mail sent for sanction letter....");
			
		}
		
	

	
}

