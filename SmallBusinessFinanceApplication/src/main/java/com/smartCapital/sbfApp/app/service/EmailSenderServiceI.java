package com.smartCapital.sbfApp.app.service;

import com.smartCapital.sbfApp.app.model.EmailSender;
import com.smartCapital.sbfApp.app.model.SanctionLetter;

public interface EmailSenderServiceI {

	public void sendEmail(EmailSender e);

	public void sendEmailWithAttachment(EmailSender e);

	public void sendSanctionMail(String toEmail, EmailSender em) throws Exception;

	
}
