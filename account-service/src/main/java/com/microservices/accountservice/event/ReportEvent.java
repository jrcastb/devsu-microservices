package com.microservices.accountservice.event;

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
    private ClientResponseDTO client;
    private String initDate;
    private String endDate;
}
