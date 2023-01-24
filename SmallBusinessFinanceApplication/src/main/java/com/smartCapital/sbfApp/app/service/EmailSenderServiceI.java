package com.smartCapital.sbfApp.app.service;

import java.util.Map;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.MailResponse;
import com.smartCapital.sbfApp.app.model.SanctionLetter;

import freemarker.template.Template;

public interface EmailSenderServiceI {

	public void sendEmail(EmailSender e);

	public void sendEmailWithAttachment(EmailSender e);

	public void sendSanctionMail(EmailSender em,Map<String, Object> model,Template t) throws Exception;

	public void sendMultipleMail(EmailSender em, Map<String, Object> mode, Template t);

	public void sendCibilMail(EmailSender em, Map<String, Object> mode, Template t);

	
}
