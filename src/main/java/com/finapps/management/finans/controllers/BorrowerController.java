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
    public ResponseEntity<List<Borrower>> getBorrowers(Authentication auth) throws Exception {
        return new ResponseEntity<>(borrowerService.getBorrowers(auth.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/borrowers")
    public ResponseEntity<Borrower> addBorrower(@RequestBody Borrower borrower, Authentication auth) throws Exception {
        return new ResponseEntity<>(borrowerService.create(borrower, auth.getName()), HttpStatus.OK);
    }

    @PatchMapping("/api/borrowers/{borrowerId}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable Long borrowerId, @RequestBody Borrower borrower, Authentication auth)
            throws Exception {
        return new ResponseEntity<>(borrowerService.update(borrowerId, borrower, auth.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/api/borrowers/{borrowerId}")
    public ResponseEntity<StringResponse> deleteBorrower(@PathVariable Long borrowerId, Authentication auth)
            throws Exception {
        return new ResponseEntity<>(new StringResponse(borrowerService.delete(borrowerId)), HttpStatus.OK);
    }

    @GetMapping("/api/borrowers/total")
    public ResponseEntity<Double> getTotalAmount(Authentication auth) throws Exception {
        return new ResponseEntity<>(borrowerService.getTotalAmount(auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/api/borrowers/{borrowerId}/loanreturns")
    public ResponseEntity<List<LoanReturns>> getLoanReturnByBorrower(@PathVariable Long borrowerId, Authentication auth){
        return new ResponseEntity<>(borrowerService.getReturnDetails(borrowerId, auth.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/borrowers/{borrowerId}/loanreturns")
    public ResponseEntity<LoanReturns> getLoanReturnByBorrower(@PathVariable Long borrowerId, @RequestBody LoanReturns loanReturns, Authentication auth){
        return new ResponseEntity<>(borrowerService.addAReturn(borrowerId, loanReturns, auth.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/api/borrowers/{borrowerId}/loanreturns/{loanReturnId}")
    public ResponseEntity<StringResponse> removeAreturn(@PathVariable Long loanReturnId, Authentication auth){
        return new ResponseEntity<>(new StringResponse(borrowerService.removeAreturn(loanReturnId)), HttpStatus.OK);
    }
}