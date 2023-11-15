package com.microservices.accountservice.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.accountservice.model.Movement;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AccountRequestDTO {
    @JsonProperty("numero_de_cuenta")
    private String accountNumber;
    @JsonProperty("tipo")
    private String accountType;
    @JsonProperty("saldo_inicial")
    private BigDecimal initialBalance;
    @JsonProperty("estado")
    private Boolean status;
    @JsonProperty("cliente_id")
    private Long clientId;

    public AccountRequestDTO(String accountNumber, String accountType, BigDecimal initialBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
    }
}
