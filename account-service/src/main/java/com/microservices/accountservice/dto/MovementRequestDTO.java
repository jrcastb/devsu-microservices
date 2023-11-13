package com.microservices.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementRequestDTO {
    private String date;
    private String movementType;
    private BigDecimal value;
    private BigDecimal balance;
}
