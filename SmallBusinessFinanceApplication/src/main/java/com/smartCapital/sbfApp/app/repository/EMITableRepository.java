package com.smartCapital.sbfApp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartCapital.sbfApp.app.model.EMITable;

@Repository
public interface EMITableRepository extends JpaRepository<EMITable, Integer>{

	List<EMITable> findAllByEmiDetailsId(Integer emiDetailsId);
}
