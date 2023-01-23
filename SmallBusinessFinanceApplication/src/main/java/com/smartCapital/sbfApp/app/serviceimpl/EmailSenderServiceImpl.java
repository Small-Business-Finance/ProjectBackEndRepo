package com.smartCapital.sbfApp.app.serviceimpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.MailResponse;
import com.smartCapital.sbfApp.app.model.SanctionLetter;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.service.EmailSenderServiceI;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
	public void sendSanctionMail(EmailSender em,Map<String, Object> model,Template t) throws Exception 
	{
		
		MimeMessage message=sender.createMimeMessage();
	
		
			try {
				MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
						StandardCharsets.UTF_8.name());
 
				
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
				
				helper = new MimeMessageHelper(message,true);
				helper.setTo(em.getToEmail());
				helper.setText(html,true);
				helper.setSubject(em.getSubject());
//				FileSystemResource resource=new FileSystemResource("C:\\Users\\Payal\\Downloads\\WhatsApp Image 2023-01-22 at 10.21.04 AM.jpeg");
//				
//				helper.addAttachment(resource.getFilename(), resource);
				
				sender.send(message);
				System.out.println(" sanction mail sent--------....");
			
			
			}
			catch (MessagingException | IOException | TemplateException e) {
			
				e.printStackTrace();
			}
		 }
	
	@Override
	public void sendMultipleMail(EmailSender em, Map<String, Object> model, Template t) {
		MimeMessage message=sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			
			helper = new MimeMessageHelper(message,true);
			helper.setTo(em.getToEmail());
			helper.setText(html,true);
			helper.setSubject(em.getSubject());
//			FileSystemResource resource=new FileSystemResource("C:\\Users\\Payal\\Downloads\\WhatsApp Image 2023-01-22 at 10.21.04 AM.jpeg");
//			
//			helper.addAttachment(resource.getFilename(), resource);
			
			sender.send(message);
			System.out.println("mail sent--------....");
		
		
		}
		catch (MessagingException | IOException | TemplateException e) {
		
			e.printStackTrace();
		}
	 
	}

	

	@Override
	public void sendCibilMail(EmailSender em, Map<String, Object> model, Template t) {

		MimeMessage message=sender.createMimeMessage();
	
		
			try {
				MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
						StandardCharsets.UTF_8.name());
 
				
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
				
				helper = new MimeMessageHelper(message,true);
				helper.setTo(em.getToEmail());
				helper.setText(html,true);
				helper.setSubject(em.getSubject());
//				FileSystemResource resource=new FileSystemResource("C:\\Users\\Payal\\Downloads\\WhatsApp Image 2023-01-22 at 10.21.04 AM.jpeg");
//				
//				helper.addAttachment(resource.getFilename(), resource);
				
				sender.send(message);
				System.out.println("low cibil mail sent--------....");
			
			
			}
			catch (MessagingException | IOException | TemplateException e) {
			
				e.printStackTrace();
			}
		
	}
	
}

