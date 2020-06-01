package com.finapps.management.finans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finapps.management.finans.models.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
