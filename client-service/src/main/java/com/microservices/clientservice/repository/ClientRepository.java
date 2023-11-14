package com.microservices.clientservice.repository;

import com.microservices.clientservice.dto.client.ClientResponseDTO;
import com.microservices.clientservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByName(String name);
}
