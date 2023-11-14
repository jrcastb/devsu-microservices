package com.microservices.accountservice.event;

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
    private String date;
    private String client;
    private String accountNumber;
    private AccountType accountType;
    private BigDecimal initialBalance;
    private Boolean status;
    private BigDecimal movement;
    private BigDecimal balance;
}
