package com.smartCapital.sbfApp.app.serviceimpl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerDetails;
import com.smartCapital.sbfApp.app.model.EMITable;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.service.PdfServiceI;

import freemarker.core.CollectionAndSequence;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfServiceImpl implements PdfServiceI
{
	@Autowired
	CustomerApplicationFormRepository cr;

	@Override
	public void generatePdf(HttpServletResponse response, Integer applicationId) throws DocumentException, IOException {
		
		CustomerApplicationForm cf =cr.findByApplicationId(applicationId);
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.green);

		Paragraph p = new Paragraph("Loan Details", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		

		document.add(p);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(16);
		font.setColor(Color.black);
		
		Paragraph p1 = new Paragraph("Application id:-"+cf.getApplicationId(), font1);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p1);
		
		Paragraph p2 = new Paragraph("Amount-"+cf.getCustomerLoanDetails().getExpectedLoanAmount(), font1);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p2);
		document.close();
		
		
	}
	
	@Override
	public void generateExcel(HttpServletResponse response, Integer applicationId)
			throws DocumentException, IOException {
		CustomerApplicationForm all = cr.findByApplicationId(applicationId);
		List<EMITable> lt=all.getCustomerLoanDetails().getEmitable();
		Collections.sort(lt,new SortEmi());
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);

		 HSSFFont headerFont = workbook.createFont();
		  headerFont.setColor(IndexedColors.WHITE.index);
		  CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
		  headerCellStyle.setDataFormat(workbook.createDataFormat().getFormat("#.##"));
		  // fill foreground color ...
		  headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
		  // and solid fill pattern produces solid grey cell fill
		  headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		  headerCellStyle.setFont(headerFont);
		 
		
		HSSFCell cell1 = row.createCell(0);
		cell1.setCellValue("emiDetailsId");
		cell1.setCellStyle(headerCellStyle);
		
		HSSFCell cell2 = row.createCell(1);
		cell2.setCellValue("emidate");
		cell2.setCellStyle(headerCellStyle);
		
		HSSFCell cell3 = row.createCell(2);
		cell3.setCellValue("emiAmount");
		cell3.setCellStyle(headerCellStyle);
		
		HSSFCell cell4 = row.createCell(3);
		cell4.setCellValue("emiTenure");
		cell4.setCellStyle(headerCellStyle);
		
		HSSFCell cell5 = row.createCell(4);
		cell5.setCellValue("emiStatus");
		cell5.setCellStyle(headerCellStyle);
		
		

		int i = 1;
		for (EMITable al : lt) {

			HSSFRow data = sheet.createRow(i);
		data.createCell(0).setCellValue(String.valueOf(i));
			data.createCell(1).setCellValue("" + al.getEmidate() + "");
			data.createCell(2).setCellValue(al.getEmiAmount());
			data.createCell(3).setCellValue(al.getEmiTenure());
			data.createCell(4).setCellValue(al.getEmiStatus());
			i++;

		}
		ServletOutputStream stream = response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}

}
