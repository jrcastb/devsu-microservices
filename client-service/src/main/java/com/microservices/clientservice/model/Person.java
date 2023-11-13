package com.microservices.clientservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "identification")
    private String identification;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
