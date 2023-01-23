package com.smartCapital.sbfApp.app.service;


import java.util.List;

import com.smartCapital.sbfApp.app.model.LeaveDetails;

public interface LeaveDetailService {

	void saveLeaveDetail(LeaveDetails leavedetails);

	void updateLeaveDetail( Integer leaveAppId, LeaveDetails leavedetails);

	Iterable<LeaveDetails> getLeaveDetails();

	void deleteLeaveDetail(Integer leaveAppId);

	List<LeaveDetails> getLeaveDetailbyId(Integer leaveAppId);

}
