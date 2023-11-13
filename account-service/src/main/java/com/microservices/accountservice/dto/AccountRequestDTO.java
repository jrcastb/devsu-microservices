package com.microservices.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDTO {
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private Boolean status;
}
