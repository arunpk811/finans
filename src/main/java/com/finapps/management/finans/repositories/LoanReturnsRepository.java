package com.finapps.management.finans.repositories;

import com.finapps.management.finans.models.Borrower;
import com.finapps.management.finans.models.LoanReturns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanReturnsRepository extends JpaRepository<LoanReturns, Long> {
    public List<LoanReturns> findAllByBorrower(Borrower borrower);
}
