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
public class LeaveDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer leaveAppId;
	private Integer empId;
	private String fromDate;
	private String toDate;
	private String leaveType;
	private String leaveappstatus;
}
