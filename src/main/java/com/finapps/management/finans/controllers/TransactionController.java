package com.finapps.management.finans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getTransactions();
	}

	@PostMapping("/transactions")
	public Transaction create(@RequestBody Transaction transaction) {
		return transactionService.create(transaction);
	}

	@PutMapping("/transactions")
	public Transaction update(@RequestBody Transaction transaction) {
		return transactionService.update(transaction);
	}

	@DeleteMapping("/transactions/{id}")
	public String delete(@PathVariable Long id) {
		return transactionService.delete(id);
	}
}
