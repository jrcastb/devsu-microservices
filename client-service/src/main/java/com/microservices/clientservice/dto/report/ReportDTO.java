package com.microservices.clientservice.dto.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.clientservice.dto.client.ClientResponseDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReportDTO {
    @JsonProperty("cliente")
    private ClientResponseDTO client;
    @JsonProperty("fecha_incial")
    private String initDate;
    @JsonProperty("fecha_final")
    private String endDate;
}
