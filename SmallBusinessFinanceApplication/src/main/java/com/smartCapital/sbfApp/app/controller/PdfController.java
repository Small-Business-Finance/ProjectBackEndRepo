package com.smartCapital.sbfApp.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.service.CustomerApplicationFormServiceI;
import com.smartCapital.sbfApp.app.service.PdfServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pdfapi")
public class PdfController {

	@Autowired
	CustomerApplicationFormServiceI csi;
	
	@Autowired
	PdfServiceI psi;
	
	@GetMapping("/genPdf/{applicationId}")
	public void getPdf(HttpServletResponse response,@PathVariable Integer applicationId)throws Exception {
		response.setContentType("application/pdf");
		CustomerApplicationForm cf= csi.getApplicationById(applicationId);
		String name=cf.getCustomerDetails().getCustomerName();
		String hk="Content-Disposition";
		String val="attachment;filename="+name+".pdf";
		response.setHeader(hk, val);
		psi.generatePdf(response, applicationId);		
	}	
}
