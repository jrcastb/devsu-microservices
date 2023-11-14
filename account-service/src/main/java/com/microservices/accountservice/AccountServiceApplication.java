package com.microservices.accountservice;

import com.microservices.accountservice.event.ReportEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @KafkaListener(topics = "reportTopic")
    public void handleReport(ReportEvent reportEvent){
        //generate report
        log.info("Orden de reporte recibida para cliente - {}", reportEvent.getClient().getName());
    }

}
