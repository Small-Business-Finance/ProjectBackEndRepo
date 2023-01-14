package com.smartCapital.sbfApp.app.dto;

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
public class GuarantorDetailsDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer guarantorId;
	private String guarantorName;
	private String guarantorPanCardNumber;
	private String relation;
	private Long mobileNumber;
	private String occupation;
}
