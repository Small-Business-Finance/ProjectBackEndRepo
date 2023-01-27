package com.smartCapital.sbfApp.app.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;

@SpringBootTest
class CustomerApplicationFormServiceImplTest {

	@Autowired
	CustomerApplicationFormServiceI csi;
	
	@MockBean
	CustomerApplicationFormRepository cr;
	
	@BeforeEach
	public void setup()
	{
//		Optional<CustomerApplicationForm> ca=Optional.of(new CustomerApplicationForm(4,"Disbursed",null,null,null,null,null,null,null));
		
//		Mockito.when(cr.findById(4)).thenReturn(ca);
		
		CustomerApplicationForm ca=new CustomerApplicationForm(4,"Disbursed",null,null,null,null,null,null,null);
		Mockito.when(cr.findByApplicationId(4)).thenReturn(ca);
		
	}
	
	@Test
	public void testgetApplicationById()
	{
		String status="Disbursed";
		CustomerApplicationForm cf=csi.getApplicationById(4);
		
		assertEquals(status,cf.getApplicationStatus());
	}

}
