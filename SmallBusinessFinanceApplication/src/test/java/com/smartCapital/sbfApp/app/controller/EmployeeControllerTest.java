package com.smartCapital.sbfApp.app.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.smartCapital.sbfApp.app.model.Employee;
import com.smartCapital.sbfApp.app.service.EmployeeServiceI;
import static org.mockito.ArgumentMatchers.*;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mm;
	
	Employee e;
	
	@MockBean
	EmployeeServiceI es;
	
	@BeforeEach
	public void setup()
	{
		e=new Employee(13391,"aaaa","1987-11-16","female",50000.0,"re","pune",9876543122L,"payalsune20@gmail.com","re","re");
		
	}
	
	@Test
	public void testSave() throws Exception
	{
		Employee ee=Employee.builder().empName("aaaa")
				.empDateofBirth("1987-11-16")
				.empGender("female")
				.empSalary(50000.0)
				.empRole("re")
		.empAddress("pune")
		.empMobileno(9876543122L)
		.empEmailId("payalsune20@gmail.com")
		.username("re")
		.password("re").build();
		
		
		Mockito.when(es.saveEmployee(ee)).thenReturn(e);
		mm.perform(MockMvcRequestBuilders.post("/employeeapi/saveemployee/").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"+" \"empId\":13391,\r\n"
						+" \"empName\": \"aaaa\",\r\n"
								+" \"empDateofBirth\": \"1987-11-16\",\r\n"
						+"\"empGender\": \"female\",\r\n"
						+"\"empSalary\": 50000.0,\r\n"
						+"\"empRole\": \"re\",\r\n"
						+"\"empAddress\": \"pune\",\r\n"
						+"\"empMobileno\": 9876543122,\r\n"
						+"\"empEmailId\": \"payalsune20@gmail.com\",\r\n"
						+"\"username\":\"re\",\r\n"
						+"\"password\": \"re\"}")).andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
