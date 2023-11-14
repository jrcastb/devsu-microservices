package com.microservices.clientservice.controller;

import com.microservices.clientservice.dto.report.ReportDTO;
import com.microservices.clientservice.service.IReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reportes")
public class ReportController {

    private final IReportService reportService;
    @PostMapping()
    public ResponseEntity<ReportDTO> saveClient(@RequestParam(name = "fecha") String dateRange, @RequestParam(name = "cliente") String client){
        return new ResponseEntity<>(reportService.generateReport(client, dateRange), HttpStatus.ACCEPTED);
    }
}
