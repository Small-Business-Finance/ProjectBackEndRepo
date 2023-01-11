package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOwner 
{
	@Id
	private Integer aadharId;
	private String ownerName;
	private String OwnerEmailId;
	private Integer OwnerMobileNo;
	private String pancard;
	private String address;
	private String dob;
	private String gender;
}

