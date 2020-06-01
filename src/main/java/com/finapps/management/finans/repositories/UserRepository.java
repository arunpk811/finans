package com.finapps.management.finans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finapps.management.finans.models.UserDetail;


public interface UserRepository extends JpaRepository<UserDetail, Long> {

	public UserDetail findByUsername(String username);
}
