package com.finapps.management.finans.controllers;

import java.util.List;

import com.finapps.management.finans.models.Loan;
import com.finapps.management.finans.services.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Loan> getLoans(Authentication auth){
        return loanService.getLoans(auth.getName());
    }

    @PostMapping("/api/loans")
    public Loan addLoan(@RequestBody Loan loan, Authentication auth){
        return loanService.create(loan, auth.getName());
    }
    @PutMapping("/api/loans")
    public Loan updateLoan(@RequestBody Loan loan, Authentication auth){
        return loanService.update(loan, auth.getName());
    }
    @DeleteMapping("/api/loans/{loanId}")
    public String deleteLoan(@PathVariable Long loanId, Authentication auth){
        return loanService.delete(loanId);
    }

}