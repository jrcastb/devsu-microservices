package com.microservices.accountservice.service;

import com.microservices.accountservice.dto.MovementRequestDTO;
import com.microservices.accountservice.dto.MovementResponseDTO;

import java.util.List;

public interface IMovementService {
    List<MovementResponseDTO> getMovements();
    MovementResponseDTO saveMovement(MovementRequestDTO movementsRequestDTO);
    MovementResponseDTO updateMovement(Long id, MovementRequestDTO movementsRequestDTO);
    void deleteMovement(Long id);
}
