package com.smartCapital.sbfApp.app.exceptionhandling;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FindByApplicationIdException.class)
	public ResponseEntity<CustomerApplicationExceptionEntity> noCustomerFound(FindByApplicationIdException e, HttpServletRequest req)
	{

		CustomerApplicationExceptionEntity eee = new CustomerApplicationExceptionEntity(
		
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(),
				LocalDate.now(),
				//HttpStatus.INTERNAL_SERVER_ERROR,
				req.getRequestURI()
				);
		
	
return new ResponseEntity<CustomerApplicationExceptionEntity>(eee,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
