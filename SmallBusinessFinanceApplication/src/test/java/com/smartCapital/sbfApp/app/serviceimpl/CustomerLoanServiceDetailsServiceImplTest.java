package com.smartCapital.sbfApp.app.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.EMITable;
import com.smartCapital.sbfApp.app.repository.CustomerLoanDetailsRepository;
import com.smartCapital.sbfApp.app.service.CustomerLoanDetailsServiceI;

@SpringBootTest
class CustomerLoanServiceDetailsServiceImplTest {

	@Autowired
	CustomerLoanDetailsServiceI cl;
	
	@Autowired
	CustomerLoanDetailsRepository cd;
	
	@BeforeEach
	public void setup() {
	
		EMITable et=new EMITable(13335,"Paid",56,12210.78,LocalDate.now());
		CustomerLoanDetails cld=new CustomerLoanDetails(13438,6000000.0,20.0,12.0,"Pending","Pending",3,null);
		Mockito.when(cd.findByEmitable_EmiDetailsId(13438)).thenReturn(cld);
		
	}
	
	@Test
	public void testupdateEmi()
	{
		//cl.updateemi()
	}

}
