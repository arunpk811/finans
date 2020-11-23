package com.finapps.management.finans.controllers;

import java.util.List;

import com.finapps.management.finans.models.Borrower;
import com.finapps.management.finans.models.LoanReturns;
import com.finapps.management.finans.models.response.StringResponse;
import com.finapps.management.finans.services.BorrowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;

    @GetMapping("/api/borrowers")
    public List<Borrower> getBorrowers(Authentication auth) throws Exception {
        return borrowerService.getBorrowers(auth.getName());
    }

    @PostMapping("/api/borrowers")
    public Borrower addBorrower(@RequestBody Borrower borrower, Authentication auth) throws Exception {
        return borrowerService.create(borrower, auth.getName());
    }

    @PatchMapping("/api/borrowers/{borrowerId}")
    public Borrower updateBorrower(@PathVariable Long borrowerId, @RequestBody Borrower borrower, Authentication auth)
            throws Exception {
        return borrowerService.update(borrowerId, borrower, auth.getName());
    }

    @DeleteMapping("/api/borrowers/{borrowerId}")
    public ResponseEntity<StringResponse> deleteBorrower(@PathVariable Long borrowerId, Authentication auth)
            throws Exception {
        return new ResponseEntity<>(new StringResponse(borrowerService.delete(borrowerId)), HttpStatus.OK);
    }

    @GetMapping("/api/borrowers/total")
    public Double getTotalAmount(Authentication auth) throws Exception {
        return borrowerService.getTotalAmount(auth.getName());
    }

    @GetMapping("/api/borrowers/{borrowerId}/loanreturns")
    public List<LoanReturns> getLoanReturnByBorrower(@PathVariable Long borrowerId, Authentication auth){
        return borrowerService.getReturnDetails(borrowerId, auth.getName());
    }

    @PostMapping("/api/borrowers/{borrowerId}/loanreturns")
    public LoanReturns getLoanReturnByBorrower(@PathVariable Long borrowerId, @RequestBody LoanReturns loanReturns, Authentication auth){
        return borrowerService.addAReturn(borrowerId, loanReturns, auth.getName());
    }

    @DeleteMapping("/api/borrowers/{borrowerId}/loanreturns/{loanReturnId}")
    public ResponseEntity<StringResponse> removeAreturn(@PathVariable Long loanReturnId, Authentication auth){
        return new ResponseEntity<>(new StringResponse(borrowerService.removeAreturn(loanReturnId)), HttpStatus.OK);
    }
}