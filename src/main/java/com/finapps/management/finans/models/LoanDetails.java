package com.finapps.management.finans.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoanDetails {
	private int emiMonth;
	private double _PrincipleAmount;
	private double _ROI;
	private int tenure;
	private double outStandingAmount;
	private double paidPrincipal;
	private double paidInterest;
	private double _EMI;
	private double loanPaidToDate;

	public LoanDetails(double _PrincipleAmount, double _ROI, int tenure) {
		this._PrincipleAmount = _PrincipleAmount;
		this._ROI = _ROI;
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "LoanDetails [_PrincipleAmount=" + _PrincipleAmount + ", _ROI=" + _ROI + ", tenure=" + tenure
				+ ", outStandingAmount=" + outStandingAmount + ", paidPrincipal=" + paidPrincipal + ", paidInterest="
				+ paidInterest + ", _EMI=" + _EMI + ", loanPaidToDate=" + loanPaidToDate + "]";
	}

}