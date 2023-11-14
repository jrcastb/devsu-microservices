package com.microservices.accountservice.service.Impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microservices.accountservice.event.Report;
import com.microservices.accountservice.event.ReportEvent;
import com.microservices.accountservice.model.Account;
import com.microservices.accountservice.model.Movement;
import com.microservices.accountservice.repository.IAccountRepository;
import com.microservices.accountservice.repository.IMovementRepository;
import com.microservices.accountservice.service.IReportService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReportService implements IReportService {

    private final IMovementRepository movementRepository;
    private final IAccountRepository accountRepository;
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String filePath = "report.json";
    @Override
    public void generateReport(ReportEvent reportEvent) {
        Long clientId = reportEvent.getClient().getId();
        List<Account> accounts = accountRepository.findAccountsByClientId(clientId);
        List<String> accountNumbers = extractAccountNumber(accounts);
        List<Movement> movements = movementRepository.findMovementsByAccount_AccountNumberIn(accountNumbers);
        List<Report> report = mergeData(reportEvent.getClient().getName(), accounts, movements);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(report, writer);
            log.info("JSON generado exitosamente en: {}", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Report> mergeData(String client, List<Account> accounts, List<Movement> movements){

        Map<Account, List<Movement>> movementsByAccount = movements.stream()
                .collect(Collectors.groupingBy(Movement::getAccount));

        return accounts.stream()
                .flatMap(account -> {
                    String accountNumber = account.getAccountNumber();
                    List<Movement> movementByAccount = movementsByAccount.getOrDefault(account, List.of());

                    return movementByAccount.stream()
                            .map( movement -> Report.builder()
                                    .date(movement.getDate().toLocalDate().format(pattern))
                                    .client(client)
                                    .accountNumber(accountNumber)
                                    .accountType(account.getAccountType())
                                    .initialBalance(account.getInitialBalance())
                                    .status(account.getStatus())
                                    .movement(movement.getValue())
                                    .balance(movement.getBalance())
                                    .build());
                }).collect(Collectors.toList());
    }

    private List<String> extractAccountNumber(List<Account> accounts){
        return accounts.stream().map(Account::getAccountNumber).collect(Collectors.toList());
    }
}
