package com.microservices.accountservice.service;

import com.microservices.accountservice.dto.movement.MovementDTO;
import com.microservices.accountservice.dto.movement.MovementRequestDTO;
import com.microservices.accountservice.dto.movement.MovementResponseDTO;

import java.util.List;

public interface IMovementService {
    List<MovementResponseDTO> getMovements();
    MovementResponseDTO saveMovement(MovementRequestDTO movementsRequestDTO);
    MovementResponseDTO updateMovement(Long id, MovementRequestDTO movementsRequestDTO);
    void deleteMovement(Long id);
    MovementResponseDTO makeMovement(MovementDTO movementDTO);
}
