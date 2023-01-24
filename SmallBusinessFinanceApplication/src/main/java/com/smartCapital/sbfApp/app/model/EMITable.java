package com.smartCapital.sbfApp.app.model;

import java.time.LocalDate;

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
public class EMITable{ 
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
			private Integer emiDetailsId;
			private String emiStatus;
			private Integer emiTenure;
			private Double emiAmount;
			private LocalDate emidate;
			
			
		}
		 

