package com.smartCapital.sbfApp.app.service;


import com.smartCapital.sbfApp.app.model.LeaveDetails;

public interface LeaveDetailService {

	void saveLeaveDetail(LeaveDetails leavedetails);

	void updateLeaveDetail( Integer id, LeaveDetails leavedetails);

	Iterable<LeaveDetails> getLeaveDetails();

	void deleteLeaveDetail(Integer leaveAppId);

	LeaveDetails getLeaveDetailbyId(Integer leaveAppId);

}
