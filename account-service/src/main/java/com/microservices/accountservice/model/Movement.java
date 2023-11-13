package com.microservices.accountservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

@Entity
@Table(name = "movement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "movement_type")
    private MovementType movementType;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "balance")
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    private Account account;

}
