package com.microservices.accountservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponseDTO {

    private Long id;
    private String name;
    private Boolean gender;
    private Integer age;
    private String identification;
    private String address;
    private String phoneNumber;
    private String clientId;
    private Boolean status;
}
