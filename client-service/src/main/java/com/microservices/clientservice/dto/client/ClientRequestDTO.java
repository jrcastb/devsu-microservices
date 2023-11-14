package com.microservices.clientservice.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequestDTO {
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
    @JsonProperty("contraseña")
    private String password;
    @JsonProperty("cliente_id")
    private String clientId;
    @JsonProperty("estado")
    private Boolean status;
}
