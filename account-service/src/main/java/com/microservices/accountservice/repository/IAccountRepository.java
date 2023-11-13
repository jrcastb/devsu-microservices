package com.microservices.accountservice.repository;

import com.microservices.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
