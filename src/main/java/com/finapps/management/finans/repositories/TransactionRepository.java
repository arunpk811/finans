package com.finapps.management.finans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.finapps.management.finans.models.Transaction;
import com.finapps.management.finans.models.Users;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    public List<Transaction> findAllByUser(Users user);
}
