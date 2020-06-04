package com.finapps.management.finans.repositories;

import java.util.List;

import com.finapps.management.finans.models.Borrower;
import com.finapps.management.finans.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    public List<Borrower> findAllByUser(Users user);
}