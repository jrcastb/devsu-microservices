package com.microservices.accountservice.repository;

import com.microservices.accountservice.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovementRepository extends JpaRepository<Movement, Long> {

    List<Movement> findMovementByAccount_AccountNumber(String accountNumber);
}
