package com.finapps.management.finans.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finapps.management.finans.models.Transaction;
import com.finapps.management.finans.models.response.StringResponse;
import com.finapps.management.finans.services.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@GetMapping("/api/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(Authentication auth) {
		return new ResponseEntity<>(transactionService.getTransactions(auth.getName()), HttpStatus.OK);
	}

	@PostMapping("/api/transactions")
	public ResponseEntity<Transaction> create(@RequestBody Transaction transaction, Authentication auth) {
		return new ResponseEntity<>(transactionService.create(transaction, auth.getName()), HttpStatus.OK);
	}

	@PatchMapping("/api/transactions/{id}")
	public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction transaction, Authentication auth) {
		return new ResponseEntity<>(transactionService.update(id, transaction, auth.getName()), HttpStatus.OK);
	}

	@DeleteMapping("/api/transactions/{id}")
	public ResponseEntity<StringResponse> delete(@PathVariable Long id, Authentication auth) {
		return new ResponseEntity<>(new StringResponse(transactionService.delete(id)), HttpStatus.OK);
	}

//	@GetMapping("/api/transactions/{bank}")
//	public ResponseEntity
}
