package com.finapps.management.finans.repositories;

import com.finapps.management.finans.models.Emi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmiRepository extends JpaRepository<Emi, Long> {
}
