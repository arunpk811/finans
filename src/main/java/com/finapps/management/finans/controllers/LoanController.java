package com.finapps.management.finans.controllers;

import java.util.List;

import com.finapps.management.finans.models.Loan;
import com.finapps.management.finans.models.response.StringResponse;
import com.finapps.management.finans.services.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoanController {
    @Autowired
    LoanService loanService;

    @GetMapping("/api/loans")
    public ResponseEntity<List<Loan>> getLoans(Authentication auth){
        return new ResponseEntity<>(loanService.getLoans(auth.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/loans")
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan, Authentication auth){
        return new ResponseEntity<>(loanService.create(loan, auth.getName()), HttpStatus.OK);
    }
    @PutMapping("/api/loans")
    public ResponseEntity<Loan> updateLoan(@RequestBody Loan loan, Authentication auth){
        return new ResponseEntity<>(loanService.update(loan, auth.getName()), HttpStatus.OK);
    }
    @DeleteMapping("/api/loans/{loanId}")
    public ResponseEntity<StringResponse> deleteLoan(@PathVariable Long loanId, Authentication auth){
        return new ResponseEntity<>(new StringResponse(loanService.delete(loanId)), HttpStatus.OK) ;
    }

}