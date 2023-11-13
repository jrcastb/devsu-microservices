package com.microservices.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequestDTO {
    private String name;
    private Boolean gender;
    private Integer age;
    private String identification;
    private String address;
    private String phoneNumber;
    private String password;
    private String clientId;
    private Boolean status;
}
