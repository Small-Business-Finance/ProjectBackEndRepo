package com.smartCapital.sbfApp.app.service;

import com.smartCapital.sbfApp.app.model.LeaveDetails;

public interface LeaveDetailService {

	void saveLeaveDetail(LeaveDetails leavedetails);

	void updateLeaveDetail(Integer empId, Integer id, LeaveDetails leavedetails);

}
