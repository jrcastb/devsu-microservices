package com.microservices.accountservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private AccountType accountType;
    @Column(name = "initial_balance")
    private BigDecimal initialBalance;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "client_id")
    private Long clientId;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<Movement> movements;
}
