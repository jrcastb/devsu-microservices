package com.microservices.accountservice;

import com.microservices.accountservice.event.ReportEvent;
import com.microservices.accountservice.service.IReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AccountServiceApplication {

    private final IReportService reportService;
    public AccountServiceApplication(IReportService reportService) {
        this.reportService = reportService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @KafkaListener(topics = "reportTopic")
    public void handleReport(ReportEvent reportEvent) throws IOException {
        //generate report
        log.info("Orden de reporte recibida para cliente - {}", reportEvent.getClient().getName());
        reportService.generateReport(reportEvent);
    }

}
