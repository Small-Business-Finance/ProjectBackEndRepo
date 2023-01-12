package com.smartCapital.sbfApp.app.service;

import com.smartCapital.sbfApp.app.model.EmailSender;

public interface EmailSenderServiceI {

	public void sendEmail(EmailSender e);

	public void sendEmailWithAttachment(EmailSender e);
}
