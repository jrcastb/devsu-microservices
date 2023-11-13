package com.microservices.accountservice.service.Impl;

import com.microservices.accountservice.dto.MovementRequestDTO;
import com.microservices.accountservice.dto.MovementResponseDTO;
import com.microservices.accountservice.model.Movement;
import com.microservices.accountservice.repository.IMovementRepository;
import com.microservices.accountservice.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MovementService implements IMovementService {

    private final IMovementRepository movementRepository;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public List<MovementResponseDTO> getMovements() {
        List<Movement> movements;
        movements = movementRepository.findAll();
        return movements.stream().map(this::mapToResponse).toList();
    }



    @Override
    public MovementResponseDTO saveMovement(MovementRequestDTO movementsRequestDTO) {
        MovementResponseDTO response;
        Movement movement = maptToMovment(movementsRequestDTO);
        movementRepository.save(movement);
        response = mapToResponse(movement);
        return response;
    }

    @Override
    public MovementResponseDTO updateMovement(Long id, MovementRequestDTO movementRequestDTO) {
        Optional<Movement> movementData = movementRepository.findById(id);
        MovementResponseDTO movementResponseDTO = new MovementResponseDTO();

        if(movementData.isPresent()){
            Movement movement = movementData.get();
            movement.setDate(LocalDate.parse(movementRequestDTO.getDate()));
            movement.setMovementType(movementRequestDTO.getMovementType());
            movement.setValue(movementRequestDTO.getValue());
            movement.setBalance(movementRequestDTO.getBalance());
        }
        return null;
    }

    @Override
    public void deleteMovement(Long id) {
        movementRepository.deleteById(id);
    }

    private Movement maptToMovment(MovementRequestDTO movementsRequestDTO) {
        return Movement.builder()
                .date(LocalDate.parse(movementsRequestDTO.getDate(), dateTimeFormatter))
                .movementType(movementsRequestDTO.getMovementType())
                .value(movementsRequestDTO.getValue())
                .balance(movementsRequestDTO.getBalance())
                .build();
    }

    private MovementResponseDTO mapToResponse(Movement movement) {
        return MovementResponseDTO.builder()
                .id(movement.getId())
                .date(movement.getDate())
                .movementType(movement.getMovementType())
                .value(movement.getValue())
                .balance(movement.getBalance())
                .build();
    }
}
