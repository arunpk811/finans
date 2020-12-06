package com.finapps.management.finans.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finapps.management.finans.models.Transaction;
import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.repositories.TransactionRepository;
import com.finapps.management.finans.repositories.UserRepository;
import com.finapps.management.finans.utils.Constants;


@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepo;
	@Autowired
	private UserRepository userRepo;
	
	public List<Transaction> getTransactions(String username){
		Users user = userRepo.findByUsername(username);
        return transactionRepo.findAllByUser(user);
	}
	
	public Transaction create(Transaction transaction, String username){
		Users user = userRepo.findByUsername(username);
        transaction.setUser(user);
		return transactionRepo.save(transaction);
	}
	
	public Transaction update(Long id, Transaction transaction, String username){
		Users user = userRepo.findByUsername(username);
        transaction.setUser(user);
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
