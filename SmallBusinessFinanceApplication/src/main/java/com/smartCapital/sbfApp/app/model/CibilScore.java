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
public class CibilScore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cibilId;
	private Integer cibilScore;
	private String cibilRemark;

}
