package com.smartCapital.sbfApp.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender {

	private String toEmail;
	private String fromEmail;
	private String subject;
	private String message;
	private String textBody;
//	private String fromemailid;
//	private String fullname;
//	private String emailid;
//	private String phonenumber;
//	private String query;
}
