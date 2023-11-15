package com.microservices.accountservice.event;

import com.microservices.accountservice.service.IReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class EventListener {

    private final IReportService reportService;
    @KafkaListener(topics = "reportTopic")
    public void handleReport(ReportEvent reportEvent) throws IOException {
        //generate report
        log.info("Orden de reporte recibida para cliente - {}", reportEvent.getClient().getName());
        reportService.generateReport(reportEvent);
    }
}
