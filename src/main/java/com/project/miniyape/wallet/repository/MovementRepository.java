package com.project.miniyape.wallet.repository;

import com.project.miniyape.wallet.domain.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Long> {
    List<Movement> findByOriginOrDestination(String origin, String destination);
}
