package com.microservices.accountservice.dto.movement;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("fecha")
    private String date;
    @JsonProperty("tipo_de_movimiento")
    private String movementType;
    @JsonProperty("movimiento")
    private BigDecimal value;
    @JsonProperty("saldo_disponible")
    private BigDecimal balance;
    @JsonProperty("cuenta")
    private String account;
}
