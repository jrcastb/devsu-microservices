package com.microservices.accountservice.service;

import com.microservices.accountservice.event.ReportEvent;

import java.io.IOException;

public interface IReportService {
    void generateReport(ReportEvent reportEvent) throws IOException;
}
