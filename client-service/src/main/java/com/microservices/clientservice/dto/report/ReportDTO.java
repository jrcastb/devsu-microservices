package com.microservices.clientservice.dto.report;

import com.microservices.clientservice.dto.client.ClientResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDTO {
    private ClientResponseDTO client;
    private String initDate;
    private String endDate;
}
