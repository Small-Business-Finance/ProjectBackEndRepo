package com.smartCapital.sbfApp.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCapital.sbfApp.app.model.LeaveDetails;
import com.smartCapital.sbfApp.app.repository.LeaveDetailRepository;
import com.smartCapital.sbfApp.app.service.LeaveDetailService;

@Service
public class LeaveDetailsServiceImpl implements LeaveDetailService{

	
	@Autowired
	LeaveDetailRepository leavedetailrepository;
	
	@Override
	public void saveLeaveDetail(LeaveDetails leavedetails) {
		
		leavedetailrepository.save(leavedetails);
	}
	
	@Override
	public void updateLeaveDetail(Integer id, LeaveDetails leavedetails) {
		LeaveDetails leavedetailutd=leavedetailrepository.findByLeaveDetailId(id);
		leavedetailutd.setLeaveAppId(leavedetails.getLeaveAppId());
		leavedetailutd.setEmpId(leavedetails.getEmpId());
		leavedetailutd.setFromDate(leavedetails.getFromDate());
		leavedetailutd.setToDate(leavedetails.getToDate());
		leavedetailutd.setLeaveType(leavedetails.getLeaveType());
		leavedetailutd.setLeaveappstatus(leavedetails.getLeaveappstatus());
		leavedetailrepository.save(leavedetailutd);
		
	}

	@Override
	public Iterable<LeaveDetails> getLeaveDetails() {
				return leavedetailrepository.findAll();
	}

	@Override
	public void deleteLeaveDetail(Integer leaveAppId) {
		
		leavedetailrepository.deleteById(leaveAppId);
	}

	@Override
	public LeaveDetails getLeaveDetailbyId(Integer leaveAppId) {
		
		return leavedetailrepository.findByLeaveDetailId(leaveAppId) ;
	}

}
