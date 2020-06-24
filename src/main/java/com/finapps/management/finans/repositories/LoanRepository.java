package com.finapps.management.finans.repositories;

import java.util.List;

import com.finapps.management.finans.models.Loan;
import com.finapps.management.finans.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    public List<Loan> findAllByUser(Users user);

    // @Query("select sum(l.amount) from Loan l join Users u on u.id= l.id where u.id = :userId")
    // public Double getTotalDept(String userId);
}