package com.microservices.clientservice.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ClientResponseDTO {

    private Long id;
    @JsonProperty("nombres")
    private String name;
    @JsonProperty("genero")
    private Boolean gender;
    @JsonProperty("edad")
    private Integer age;
    @JsonProperty("identificacion")
    private String identification;
    @JsonProperty("direccion")
    private String address;
    @JsonProperty("telefono")
    private String phoneNumber;
    @JsonProperty("cliente_id")
    private String clientId;
    @JsonProperty("estado")
    private Boolean status;
}
