package com.microservices.clientservice.service.impl;

import com.microservices.clientservice.dto.client.ClientResponseDTO;
import com.microservices.clientservice.dto.report.ReportDTO;
import com.microservices.clientservice.service.ClientService;
import com.microservices.clientservice.service.IReportService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportServiceImpl implements IReportService {

    private final ClientService clientService;
    private final KafkaTemplate<String, ReportDTO> kafkaTemplate;
    @Override
    public ReportDTO generateReport(String client, String dateRange) {

        ClientResponseDTO clientResponseDTO = clientService.getClientByName(client);
        String initDate = splitDate(dateRange).get(0);
        String endDate = splitDate(dateRange).get(1);

        ReportDTO reportParameters =  ReportDTO.builder()
                .client(clientResponseDTO)
                .initDate(initDate)
                .endDate(endDate)
                .build();

        kafkaTemplate.send("reportTopic", reportParameters);

        return reportParameters;
    }
    //Validar agregar este metodo en un paquete utils
    private List<String> splitDate(String date){
        String[] splited = date.split("-");
        return new ArrayList<>(Arrays.asList(splited));
    }
}
