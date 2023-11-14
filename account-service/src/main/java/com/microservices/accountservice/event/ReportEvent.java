package com.microservices.accountservice.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.accountservice.dto.client.ClientResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportEvent {
    @JsonProperty("cliente")
    private ClientResponseDTO client;
    @JsonProperty("fecha_incial")
    private String initDate;
    @JsonProperty("fecha_final")
    private String endDate;
}
