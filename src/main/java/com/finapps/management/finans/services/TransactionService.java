package com.finapps.management.finans.services;

import com.finapps.management.finans.models.Account;
import com.finapps.management.finans.models.Transaction;
import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.repositories.AccountRepository;
import com.finapps.management.finans.repositories.TransactionRepository;
import com.finapps.management.finans.repositories.UserRepository;
import com.finapps.management.finans.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> getTransactions(String username) {
        Users user = userRepo.findByUsername(username);
        return transactionRepo.findAllByUser(user);
    }

    public Transaction create(Transaction transaction, String username) {
        try {
            Users user = userRepo.findByUsername(username);
            transaction.setUser(user);
            transaction = transactionRepo.saveAndFlush(transaction);
            Account account = accountRepository.findById(transaction.getAccount().getId()).orElseThrow(() -> new RuntimeException("Account not found"));
            if (transaction.getType() != null && transaction.getType().equals("income")) {
                account.setBalance(account.getBalance() + transaction.getAmount());
            } else if (transaction.getType() != null && transaction.getType().equals("expense")) {
                account.setBalance(account.getBalance() - transaction.getAmount());
            }
            account.setUser(user);
            accountRepository.saveAndFlush(account);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
        return transaction;
    }

    public Transaction update(Long id, Transaction transaction, String username) {
        return null;
    }

    public String delete(Long id, String username ) {
        try {
            Users user = userRepo.findByUsername(username);
            Transaction transaction = transactionRepo.findById(id).orElseThrow(RuntimeException::new);

            Account account = accountRepository.findById(transaction.getAccount().getId()).orElseThrow(() -> new RuntimeException("Account Entity not found"));
            if (transaction.getType() != null && transaction.getType().equals("income")) {
                account.setBalance(account.getBalance() - transaction.getAmount());
            } else if (transaction.getType() != null && transaction.getType().equals("expense")) {
                account.setBalance(account.getBalance() + transaction.getAmount());
            }
            account.setUser(user);
            accountRepository.saveAndFlush(account);
            transactionRepo.deleteById(id);
            return Constants.RECORD_DELETED_SUCCESSFULLY;
        } catch (Exception e) {
            return Constants.CRUD_ERROR;
        }
    }

}
