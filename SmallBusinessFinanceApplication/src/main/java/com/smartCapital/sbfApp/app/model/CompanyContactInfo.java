package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyContactInfo 
{
	@Id
	private Integer mobileNo;
	private String emailId;
	private Integer faxnNo;
	private String address;

}
