package com.finapps.management.finans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finapps.management.finans.models.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
}
