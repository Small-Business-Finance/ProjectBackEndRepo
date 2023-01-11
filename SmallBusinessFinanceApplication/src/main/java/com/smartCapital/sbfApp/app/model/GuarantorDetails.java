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
public class GuarantorDetails {

	@Id
	private Integer guarantorDetailsId;
	private String guarantorName;
	private String guarantorPANCard;
	private String relation;
	private long guarantorMobileNo;
	private String Occupation;
}
