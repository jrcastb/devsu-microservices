package com.microservices.accountservice.service.Impl;

import com.microservices.accountservice.dto.account.AccountRequestDTO;
import com.microservices.accountservice.dto.account.AccountResponseDTO;
import com.microservices.accountservice.model.Account;
import com.microservices.accountservice.model.AccountType;
import com.microservices.accountservice.repository.IAccountRepository;
import com.microservices.accountservice.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;

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
            account.setAccountType(AccountType.valueOf(accountRequestDTO.getAccountType()));
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
                .accountType(AccountType.valueOf(accountRequestDTO.getAccountType()))
                .initialBalance(accountRequestDTO.getInitialBalance())
                .status(accountRequestDTO.getStatus())
                .clientId(accountRequestDTO.getClientId())
                .build();
    }
    private AccountResponseDTO mapToResponse(Account account) {
        return AccountResponseDTO.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountType(String.valueOf(account.getAccountType()))
                .initialBalance(account.getInitialBalance())
                .status(account.getStatus())
                .clientId(account.getClientId())
                .build();
    }
}
