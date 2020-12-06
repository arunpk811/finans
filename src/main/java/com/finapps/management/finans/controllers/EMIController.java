package com.finapps.management.finans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finapps.management.finans.models.LoanDetails;
import com.finapps.management.finans.utils.EMIUtil;


@RestController
@CrossOrigin
public class EMIController {

	@Autowired
	EMIUtil emiUtil;

	@GetMapping("/api/calculate/{principle}/{roi}/{tenure}")
	public ResponseEntity<List<LoanDetails>> calculateEmi(@PathVariable double principle, @PathVariable double roi,
														 @PathVariable int tenure, Authentication auth) {
		LoanDetails loanDetails = new LoanDetails(principle, roi, tenure);
		return new ResponseEntity<>(emiUtil.getEmiDetails(loanDetails), HttpStatus.OK);
	}

	@GetMapping("/api/totalintpayable/{principle}/{roi}/{tenure}")
	public ResponseEntity<String> totalIntPayable(@PathVariable double principle, @PathVariable double roi, @PathVariable int tenure,
			Authentication auth) {
		LoanDetails loanDetails = new LoanDetails(principle, roi, tenure);
		return new ResponseEntity<>(emiUtil.getTotalInterestPayable(loanDetails) + "", HttpStatus.OK);
	}

	@GetMapping("/api/totalamtpayable/{principle}/{roi}/{tenure}")
	public ResponseEntity<String> totalAmtPayable(@PathVariable double principle, @PathVariable double roi, @PathVariable int tenure,
			Authentication auth) {
		LoanDetails loanDetails = new LoanDetails(principle, roi, tenure);
		return new ResponseEntity<>(emiUtil.getTotalAmtPayable(loanDetails) + "", HttpStatus.OK);
	}
}