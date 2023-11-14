package com.microservices.accountservice.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.accountservice.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Report {
    @JsonProperty("fecha")
    private String date;
    @JsonProperty("cliente")
    private String client;
    @JsonProperty("numero_de_cuenta")
    private String accountNumber;
    @JsonProperty("tipo")
    private AccountType accountType;
    @JsonProperty("saldo_incial")
    private BigDecimal initialBalance;
    @JsonProperty("estado")
    private Boolean status;
    @JsonProperty("movimiento")
    private BigDecimal movement;
    @JsonProperty("saldo_disponible")
    private BigDecimal balance;
}
