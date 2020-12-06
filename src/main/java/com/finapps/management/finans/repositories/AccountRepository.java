package com.finapps.management.finans.repositories;

import com.finapps.management.finans.models.Borrower;
import com.finapps.management.finans.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finapps.management.finans.models.Account;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {
    public List<Account> findAllByUser(Users user);
}
