package com.finapps.management.finans.controllers;

import java.util.List;

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

import com.finapps.management.finans.models.Transaction;
import com.finapps.management.finans.services.TransactionService;


@RestController
@CrossOrigin
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@GetMapping("/api/transactions")
	public List<Transaction> getAllTransactions(Authentication auth) {
		return transactionService.getTransactions(auth.getName());
	}

	@PostMapping("/api/transactions")
	public Transaction create(@RequestBody Transaction transaction, Authentication auth) {
		return transactionService.create(transaction, auth.getName());
	}

	@PutMapping("/api/transactions")
	public Transaction update(@RequestBody Transaction transaction, Authentication auth) {
		return transactionService.update(transaction, auth.getName());
	}

	@DeleteMapping("/api/transactions/{id}")
	public String delete(@PathVariable Long id, Authentication auth) {
		return transactionService.delete(id);
	}
}
