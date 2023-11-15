package com.microservices.accountservice.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.accountservice.model.Movement;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {
    private Long id;
    @JsonProperty("cliente_id")
    private Long clientId;
    @JsonProperty("numero_de_cuenta")
    private String accountNumber;
    @JsonProperty("tipo")
    private String accountType;
    @JsonProperty("saldo_inicial")
    private BigDecimal initialBalance;
    @JsonProperty("estado")
    private Boolean status;
}
