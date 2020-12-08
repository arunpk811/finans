package com.finapps.management.finans.controllers;

import com.finapps.management.finans.models.Account;
import com.finapps.management.finans.models.AccountType;
import com.finapps.management.finans.models.Banks;
import com.finapps.management.finans.models.requests.AccountDetailsRequest;
import com.finapps.management.finans.models.response.BankDetailsResponse;
import com.finapps.management.finans.models.response.StringResponse;
import com.finapps.management.finans.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/api/accounts")
    public ResponseEntity<List<Account>> getAccounts(Authentication auth) throws Exception {
        return new ResponseEntity<>(accountService.getAccounts(auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/api/accounts/active")
    public ResponseEntity<List<Account>> getActiveAccounts(Authentication auth) throws Exception {
        return new ResponseEntity<>(accountService.getActiveAccounts(auth.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDetailsRequest request, Authentication auth) throws Exception {
        return new ResponseEntity<>(accountService.create(request, auth.getName()), HttpStatus.OK);
    }

    @PatchMapping("/api/accounts/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody AccountDetailsRequest request, @PathVariable Long accountId , Authentication auth) throws Exception {
        return new ResponseEntity<>(accountService.update(accountId, request , auth.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/api/accounts/{accountId}")
    public ResponseEntity<StringResponse> deleteAccount(@PathVariable Long accountId , Authentication auth) throws Exception {
        return new ResponseEntity<>(new StringResponse(accountService.delete(accountId, auth.getName())), HttpStatus.OK);
    }

    @GetMapping("/api/accounts/banks")
    public ResponseEntity<List<BankDetailsResponse>> getBanks(Authentication auth) throws Exception{
        return new ResponseEntity<>(accountService.getBanks(auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/api/accounts/types")
    public ResponseEntity<List<AccountType>> getAccountTypes(Authentication auth) throws Exception{
        return new ResponseEntity<>(accountService.getAccountTypes(auth.getName()), HttpStatus.OK);
    }
}
