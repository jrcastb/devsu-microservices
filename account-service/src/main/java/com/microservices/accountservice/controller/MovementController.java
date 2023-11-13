package com.microservices.accountservice.controller;

import com.microservices.accountservice.dto.movement.MovementDTO;
import com.microservices.accountservice.dto.movement.MovementRequestDTO;
import com.microservices.accountservice.dto.movement.MovementResponseDTO;
import com.microservices.accountservice.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovementController {
    private final IMovementService movementService;

    @PostMapping("/make")
    public ResponseEntity<MovementResponseDTO> makeMovement(@RequestBody MovementDTO movement){
        return new ResponseEntity<>(movementService.makeMovement(movement), HttpStatus.CREATED);
    }

    //CRUD
    @GetMapping
    public ResponseEntity<List<MovementResponseDTO>> getMovements(){
        return new ResponseEntity<>(movementService.getMovements(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<MovementResponseDTO> saveMovement(@RequestBody MovementRequestDTO movementRequestDTO){
        return new ResponseEntity<>(movementService.saveMovement(movementRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementResponseDTO> updateMovement(@PathVariable Long id, @RequestBody MovementRequestDTO movementRequestDTO){
        return new ResponseEntity<>(movementService.updateMovement(id, movementRequestDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMovement(@PathVariable Long id){
        movementService.deleteMovement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
