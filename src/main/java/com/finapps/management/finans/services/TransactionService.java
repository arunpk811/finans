package com.finapps.management.finans.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finapps.management.finans.models.Transaction;
import com.finapps.management.finans.repositories.TransactionRepository;
import com.finapps.management.finans.utils.Constants;


@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepo;
	
	public List<Transaction> getTransactions(){
		return transactionRepo.findAll();
	}
	
	public Transaction create(Transaction transaction){
		return transactionRepo.save(transaction);
	}
	
	public Transaction update(Transaction transaction){
		return transactionRepo.save(transaction);
	}
	
	public String delete(Long id) {
		try {
			transactionRepo.deleteById(id);
			return Constants.RECORD_DELETED_SUCCESSFULLY;
		} catch (Exception e) {
			return Constants.CRUD_ERROR;
		}
	}
}
