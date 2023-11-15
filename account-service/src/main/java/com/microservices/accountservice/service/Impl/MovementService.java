package com.microservices.accountservice.service.Impl;

import com.microservices.accountservice.dto.movement.MovementDTO;
import com.microservices.accountservice.dto.movement.MovementRequestDTO;
import com.microservices.accountservice.dto.movement.MovementResponseDTO;
import com.microservices.accountservice.exception.ApiException;
import com.microservices.accountservice.model.Account;
import com.microservices.accountservice.model.Movement;
import com.microservices.accountservice.model.MovementType;
import com.microservices.accountservice.repository.IAccountRepository;
import com.microservices.accountservice.repository.IMovementRepository;
import com.microservices.accountservice.service.IAccountService;
import com.microservices.accountservice.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor

public class MovementService implements IMovementService {

    private final IMovementRepository movementRepository;
    private final IAccountRepository accountRepository;

    private static final String WITHDRAWAL = "RETIRO";
    private static final String DEPOSIT = "DEPOSITO";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm");
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String baseHour = "T00:00";
    @Override
    public List<MovementResponseDTO> getMovements() {
        List<Movement> movements;
        movements = movementRepository.findAll();
        return movements.stream().map(this::mapToResponse).toList();
    }
    @Transactional
    @Override
    public MovementResponseDTO saveMovement(MovementRequestDTO movementsRequestDTO) {
        Movement movement = maptToMovement(movementsRequestDTO);
        movementRepository.save(movement);
        return mapToResponse(movement);
    }
    @Transactional
    @Override
    public MovementResponseDTO updateMovement(Long id, MovementRequestDTO movementRequestDTO) {
        Optional<Movement> movementData = movementRepository.findById(id);
        MovementResponseDTO movementResponseDTO = new MovementResponseDTO();

        if(movementData.isPresent()){
            Movement movement = movementData.get();
            movement.setDate(LocalDateTime.parse(movementRequestDTO.getDate()+baseHour, dateTimeFormatter));
            movement.setMovementType(MovementType.valueOf(movementRequestDTO.getMovementType().toUpperCase()));
            movement.setValue(movementRequestDTO.getValue());
            movement.setBalance(movementRequestDTO.getBalance());
            movementRepository.save(movement);
            movementResponseDTO = mapToResponse(movement);
        }
        return movementResponseDTO;
    }

    @Override
    public void deleteMovement(Long id) {
        movementRepository.deleteById(id);
    }
    @Transactional
    @Override
    public MovementResponseDTO makeMovement(MovementDTO movement) {
        Optional<Account> accountData = accountRepository.findAccountByAccountNumber(movement.getAccountNumber());
        MovementResponseDTO response = new MovementResponseDTO();

        if (accountData.isPresent()){
            int movementSize = splitValue(movement.getMovement()).size();
            int lastMovement = movementSize-1;
            String movementValue = splitValue(movement.getMovement()).get(lastMovement);
            String movementType = splitValue(movement.getMovement()).get(0);

            Account account = accountData.get();
            List<Movement> movementsByAccount = movementRepository.findMovementByAccount_AccountNumber(accountData.get().getAccountNumber());
            movementsByAccount.sort((Comparator.comparing(Movement::getDate).reversed()));

            BigDecimal balance = movementsByAccount.get(0).getBalance();
            BigDecimal operation = makeOperation(movementType.toUpperCase(), BigDecimal.valueOf(Double.parseDouble(movementValue)), balance);

            Movement resultMovement = Movement.builder()
                    .date(LocalDateTime.now())
                    .movementType(MovementType.valueOf(movementType.toUpperCase()))
                    .value(BigDecimal.valueOf(Double.parseDouble(movementValue)))
                    .balance(operation)
                    .account(account)
                    .build();

            response = mapToResponse(movementRepository.save(resultMovement));
        }
        return response;
    }
    private BigDecimal makeOperation(String type, BigDecimal amount, BigDecimal balance){
        BigDecimal result;
        BigDecimal depositResult = balance.add(amount);
        BigDecimal withdrawalResult = balance.subtract(amount);
        if (type.equals(MovementService.WITHDRAWAL) && isValidOperation(withdrawalResult)){
            result = withdrawalResult;
        } else if (type.equals(MovementService.DEPOSIT) && isValidOperation(amount)) {
            result = depositResult;
        } else {
            throw new ApiException("400", "saldo no disponible", 400);
        }
        return result;
    }
    private Boolean isValidOperation(BigDecimal operation){
        return operation.signum() > 0;
    }
    private List<String> splitValue(String movement){
        String[] splited = movement.split(" ");
        return new ArrayList<>(Arrays.asList(splited));
    }

    private Movement maptToMovement(MovementRequestDTO movementsRequestDTO) {

        Optional<Account> accountData = accountRepository.findAccountByAccountNumber(movementsRequestDTO.getAccount());
        Movement movement;
        if (accountData.isPresent()){
            movement =  Movement.builder()
                    .date(LocalDateTime.parse(movementsRequestDTO.getDate() + baseHour, dateTimeFormatter))
                    .movementType(MovementType.valueOf(movementsRequestDTO.getMovementType().toUpperCase()))
                    .value(movementsRequestDTO.getValue())
                    .balance(movementsRequestDTO.getBalance())
                    .account(accountData.get())
                    .build();
        }else {
            movement =  Movement.builder()
                    .date(LocalDateTime.parse(movementsRequestDTO.getDate()+baseHour, dateTimeFormatter))
                    .movementType(MovementType.valueOf(movementsRequestDTO.getMovementType().toUpperCase()))
                    .value(movementsRequestDTO.getValue())
                    .balance(movementsRequestDTO.getBalance())
                    .build();
        }
        return movement;
    }

    private MovementResponseDTO mapToResponse(Movement movement) {
        LocalDateTime dateTime = movement.getDate();
        LocalDate date = dateTime.toLocalDate();
        return MovementResponseDTO.builder()
                .id(movement.getId())
                .date(date.format(dateFormatter))
                .movementType(String.valueOf(movement.getMovementType()).toUpperCase())
                .value(movement.getValue())
                .balance(movement.getBalance())
                .build();
    }
}
