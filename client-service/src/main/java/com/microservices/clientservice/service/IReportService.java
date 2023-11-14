package com.microservices.clientservice.service;

import com.microservices.clientservice.dto.report.ReportDTO;

public interface IReportService {
    ReportDTO generateReport(String client, String dateRange);
}
