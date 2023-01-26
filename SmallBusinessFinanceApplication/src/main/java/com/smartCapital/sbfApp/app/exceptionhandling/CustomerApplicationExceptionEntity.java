package com.smartCapital.sbfApp.app.exceptionhandling;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerApplicationExceptionEntity {

	private int errorCode;
	private String exceptionMessage;
	private LocalDate timeAndDate;
	//private HttpStatusCode statusCode;
	private String uri;
}
