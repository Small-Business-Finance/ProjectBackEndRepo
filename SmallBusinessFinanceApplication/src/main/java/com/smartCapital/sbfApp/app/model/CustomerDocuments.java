package com.smartCapital.sbfApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDocuments
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer documentId;
	@Lob
	private byte[] itrReturns;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] moa;
	@Lob
	private byte[] aoa;
	@Lob
	private byte[] auditReport;
	@Lob
	private byte[] tan;
	@Lob
	private byte[] msmeCertificate;
}
