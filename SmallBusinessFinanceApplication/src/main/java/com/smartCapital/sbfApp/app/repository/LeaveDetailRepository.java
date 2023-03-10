package com.smartCapital.sbfApp.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartCapital.sbfApp.app.model.LeaveDetails;

@Repository
public interface LeaveDetailRepository extends CrudRepository<LeaveDetails, Integer> {

	LeaveDetails findByLeaveAppId(Integer leaveAppId);
	List<LeaveDetails> findByEmpId(Integer abc);

}
