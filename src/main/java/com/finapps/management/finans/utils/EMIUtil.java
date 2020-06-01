package com.finapps.management.finans.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.finapps.management.finans.models.LoanDetails;


@Component
public class EMIUtil {

	public double getEmi(LoanDetails loanDetails) {
		double emi = 0;
		double roi = loanDetails.get_ROI();
		double principle = loanDetails.get_PrincipleAmount();
		double tenure = loanDetails.getTenure();

		roi = roi / 12 / 100;
		if (principle != 0 && roi != 0 && tenure != 0) {
			emi = principle * roi * (Math.pow((1 + roi), tenure)) / ((Math.pow((1 + roi), tenure) - 1));
		}
		return Math.round(emi*100.00)/100.00;
	}

	public double getTotalInterestPayable(LoanDetails loanDetails) {
		double totalInterest;
		totalInterest = (getEmi(loanDetails) * loanDetails.getTenure()) - loanDetails.get_PrincipleAmount();
		return Math.round(totalInterest);
	}
	
	public double getTotalAmtPayable(LoanDetails loanDetails) {
		double totalAmount;
		totalAmount = (getEmi(loanDetails) * loanDetails.getTenure());
		return Math.round(totalAmount);
	}

	public List<LoanDetails> getEmiDetails(LoanDetails loanDetails) {
		ArrayList<LoanDetails> listOfLoanDetails = new ArrayList<LoanDetails>();
		int tenure = loanDetails.getTenure();
		double principleAmnt = loanDetails.get_PrincipleAmount();
		double roi = loanDetails.get_ROI();
		double emi = getEmi(loanDetails);
		double outStdnAmnt = principleAmnt;
		for(int i = 1; i <= tenure; i++) {
			LoanDetails ld = getEMIBreakUp(principleAmnt, outStdnAmnt, roi, emi);
			ld.setTenure(tenure);
			ld.setEmiMonth(i);
			outStdnAmnt = ld.getOutStandingAmount();
			listOfLoanDetails.add(ld);
		}
		return listOfLoanDetails;

	}

	public LoanDetails getEMIBreakUp(double principleAmnt, double outStdnAmnt, double roi, double emi) {
		LoanDetails loanDtls = new LoanDetails();
		double monthlyIntRate = roi / 12 / 100;
		double intComponentOfEmi = monthlyIntRate * outStdnAmnt;
		double princComponentOfEmi = emi - intComponentOfEmi;
		double outStandingLoanAmnt = outStdnAmnt - princComponentOfEmi;
		double loanPaidToDate = ((principleAmnt - outStandingLoanAmnt) / principleAmnt) * 100;
		
		loanDtls.set_EMI(Math.round(emi));
		loanDtls.set_PrincipleAmount(principleAmnt);
		loanDtls.set_ROI(roi);
		loanDtls.setLoanPaidToDate(Math.round(loanPaidToDate*100.0)/100.0);
		loanDtls.setPaidPrincipal(Math.round(princComponentOfEmi));
		loanDtls.setPaidInterest(Math.round(intComponentOfEmi));
		loanDtls.setOutStandingAmount(Math.round(outStandingLoanAmnt));
		
		return loanDtls;
	}
	
	// public static void main(String[] args) {
	// 	EMIUtil loanservice = new EMIUtil();
	// 	loanservice.getEmiDetails(new LoanDetails(450000, 11.99, 36));
	// }
}