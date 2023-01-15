package com.smartCapital.sbfApp.app.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.smartCapital.sbfApp.app.dto.EmailSenderDto;
import com.smartCapital.sbfApp.app.model.EmailSender;

@Mapper
public interface EmailSenderServiceIMapper 
{
	EmailSenderServiceIMapper Instance=Mappers.getMapper(EmailSenderServiceIMapper.class);
	
	public EmailSender toEmailSender(EmailSenderDto emailsenderdto);
	public EmailSenderDto toEmailSenderDto(EmailSender emailsender);
	
	
	

}
