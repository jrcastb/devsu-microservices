package com.microservices.clientservice.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person{

    @Column(name = "clientId") @NonNull
    private String clientId;
    @Column(name = "password") @NonNull
    private String password;
    @Column(name = "status")
    private Boolean status;

    @Builder(builderMethodName = "clientBuilder")
    public Client(Long id, String name, Boolean gender, Integer age, String identification,
                  String address, String phoneNumber, String clientId, String password, Boolean status){
        super(id, name, gender, age, identification, address, phoneNumber);
        this.clientId = clientId;
        this.password = password;
        this.status = status;
    }
}


