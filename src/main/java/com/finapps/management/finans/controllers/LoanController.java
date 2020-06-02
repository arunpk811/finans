package com.finapps.management.finans.controllers;

import java.util.List;

import com.finapps.management.finans.models.Loan;
import com.finapps.management.finans.services.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @Autowired
    LoanService loanService;

    @GetMapping("/loans/{userId}")
    public List<Loan> getLoans(@PathVariable Long userId){
        return loanService.getLoans(userId);
    }

    @PostMapping("/loans")
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.create(loan);
    }
    @PutMapping("/loans")
    public Loan updateLoan(@RequestBody Loan loan){
        return loanService.update(loan);
    }
    @DeleteMapping("/loans/{loanId}")
    public String deleteLoan(@PathVariable Long loanId){
        return loanService.delete(loanId);
    }

}