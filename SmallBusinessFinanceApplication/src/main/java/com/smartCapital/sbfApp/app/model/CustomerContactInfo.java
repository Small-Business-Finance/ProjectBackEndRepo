package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerContactInfo 
{
	@Id
	private Long mobileNumber;
	private String emailId;
	private Integer faxNumber;
	private String address;

}