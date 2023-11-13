package com.microservices.accountservice.dto.movement;

import com.microservices.accountservice.dto.account.AccountRequestDTO;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementDTO extends AccountRequestDTO {
    private String movement;

    @Builder(builderMethodName = "movementBuilder")
    public MovementDTO(String accountNumber, String accountType, BigDecimal initialBalance, String movement){
        super(accountNumber, accountType, initialBalance);
        this.movement = movement;
    }
}
