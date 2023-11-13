package com.microservices.accountservice.service.Impl;

import com.microservices.accountservice.dto.AccountRequestDTO;
import com.microservices.accountservice.dto.AccountResponseDTO;
import com.microservices.accountservice.model.Account;
import com.microservices.accountservice.repository.IAccountRepository;
import com.microservices.accountservice.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;
    private final WebClient.Builder webClientBuilder;


    @Override
    public List<AccountResponseDTO> getAccounts() {
        List<Account> accounts;
        accounts = accountRepository.findAll();
        return accounts.stream().map(this::mapToResponse).toList();
    }

    @Override
    public AccountResponseDTO saveAccount(AccountRequestDTO accountRequestDTO) {
        AccountResponseDTO response;
        Account account = mapToAccount(accountRequestDTO);
        accountRepository.save(account);
        response = mapToResponse(account);
        return response;
    }

    @Override
    public AccountResponseDTO updateAccount(Long id, AccountRequestDTO accountRequestDTO) {
        Optional<Account> accountData = accountRepository.findById(id);
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();

        if(accountData.isPresent()){
            Account account = accountData.get();
            account.setAccountNumber(accountRequestDTO.getAccountNumber());
            account.setAccountType(accountRequestDTO.getAccountType());
            account.setInitialBalance(accountRequestDTO.getInitialBalance());
            account.setStatus(accountRequestDTO.getStatus());
            accountRepository.save(account);
            accountResponseDTO = mapToResponse(account);
        }

        return accountResponseDTO;
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    private Account mapToAccount(AccountRequestDTO accountRequestDTO) {
        return Account.builder()
                .accountNumber(accountRequestDTO.getAccountNumber())
                .accountType(accountRequestDTO.getAccountType())
                .initialBalance(accountRequestDTO.getInitialBalance())
                .status(accountRequestDTO.getStatus())
                .build();
    }
    private AccountResponseDTO mapToResponse(Account account) {
        return AccountResponseDTO.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .initialBalance(account.getInitialBalance())
                .status(account.getStatus())
                .build();
    }
}
