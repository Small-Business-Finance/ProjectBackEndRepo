package com.smartCapital.sbfApp.app.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smartCapital.sbfApp.app.model.Employee;
import com.smartCapital.sbfApp.app.repository.EmployeeRepository;
import com.smartCapital.sbfApp.app.service.EmployeeServiceI;

@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	EmployeeServiceI es;
	
	@MockBean
	EmployeeRepository er;
	
	@BeforeEach
	public void setup()
	{
		Optional<Employee> e=Optional.of(new Employee(13391,"aaaa","1987-11-16","female",50000.0,"re","pune",9876543122L,"payalsune20@gmail.com","re","re"));
		Mockito.when(er.findByEmpId(13391)).thenReturn(e.get());
	}
	
	@Test
	public void testGetEmployeeById()
	{
		String name="aaaa";
		Employee ee=es.getEmployeebyId(13391);
		assertEquals(name,ee.getEmpName());
	}
	

}
