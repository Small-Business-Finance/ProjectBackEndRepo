package com.smartCapital.sbfApp.app.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

public interface PdfServiceI {

	void generatePdf(HttpServletResponse response, Integer applicationId) throws DocumentException, IOException;

}
