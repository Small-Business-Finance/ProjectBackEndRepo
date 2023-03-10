package com.smartCapital.sbfApp.app.serviceimpl;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Now;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.Emitable;

import com.smartCapital.sbfApp.app.model.CustomerApplicationForm;
import com.smartCapital.sbfApp.app.model.CustomerLoanDetails;
import com.smartCapital.sbfApp.app.model.EMITable;
import com.smartCapital.sbfApp.app.repository.CustomerApplicationFormRepository;
import com.smartCapital.sbfApp.app.repository.CustomerLoanDetailsRepository;
import com.smartCapital.sbfApp.app.repository.EMITableRepository;
import com.smartCapital.sbfApp.app.service.CustomerLoanDetailsServiceI;

@Service
public class CustomerLoanServiceDetailsServiceImpl implements CustomerLoanDetailsServiceI {

	@Autowired
	CustomerLoanDetailsRepository csr;
	
	@Autowired
	CustomerApplicationFormRepository cr;
	
	@Autowired
	EMITableRepository er;
	 private static final DecimalFormat df = new DecimalFormat("0.00");
	
	@Override
	public void updateLoanDetails(Integer applicationId) {
		CustomerApplicationForm ca=cr.findByApplicationId(applicationId);
		String String1 = ca.getApplicationStatus();
		String String2 = "Disbursed";
		if(!String1.equals(String2)) {
		List<EMITable> emilist=new ArrayList<EMITable>();
		CustomerLoanDetails ld=ca.getCustomerLoanDetails();
		
		


		double p=ld.getExpectedLoanAmount();
		double n=ld.getExpectedLoanTenure();
		double r=ld.getRateOfInterest()/(12*100);
		double emi=p * r * (Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
		System.out.println(emi);
		LocalDate date=LocalDate.now();
		for(int i=1;i<=ld.getExpectedLoanTenure();i++) {
			date=date.plusMonths(1);
			EMITable emi12=new EMITable();
			String xx=df.format(emi);
			Double yy=Double.parseDouble(xx);
			emi12.setEmiAmount(yy);
			emi12.setEmidate(date);
			emi12.setEmiStatus("Waiting");
			emi12.setEmiTenure((int) n);
			emilist.add(emi12);
		}
		ld.setEmitable(emilist);
		ca.setCustomerLoanDetails(ld);
		ca.setApplicationStatus("Disbursed");
  		cr.save(ca);
		}

	}

	@Override
	public List<CustomerApplicationForm> getDefaulter() {
		
return cr.findByCustomerLoanDetails_DefaultorCountGreaterThan(0);
	}

	@Override
	public String updateemi(EMITable et) {
		
		CustomerLoanDetails cd=csr.findByEmitable_EmiDetailsId(et.getEmiDetailsId());
		System.out.println("EMI Status: "+et.getEmiStatus());
		System.out.println("Initial Count: "+cd.getDefaultorCount());
		er.save(et);
		Integer d=csr.countEmitableByLoanDetailsIdAndEmiStatus(cd.getLoanId(), "Unpaid");
		cd.setDefaultorCount(d);
		csr.save(cd);
		System.out.println("Final Count: "+d);
		Integer r=csr.countEmitableByLoanDetailsIdAndEmiStatus(cd.getLoanId(), "Paid");
		if(r==et.getEmiTenure()) {
			CustomerApplicationForm caf=cr.findByCustomerLoanDetails(cd);
			caf.setApplicationStatus("Closed");
			cr.save(caf);
		}
		return "EMI Updated!!!";
	}

}
