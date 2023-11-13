package com.microservices.accountservice.repository;

import com.microservices.accountservice.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovementRepository extends JpaRepository<Movement, Long> {
}
