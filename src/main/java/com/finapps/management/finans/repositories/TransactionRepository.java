package com.finapps.management.finans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finapps.management.finans.models.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
