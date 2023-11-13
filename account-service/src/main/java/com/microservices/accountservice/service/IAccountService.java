package com.microservices.accountservice.service;

import com.microservices.accountservice.dto.AccountRequestDTO;
import com.microservices.accountservice.dto.AccountResponseDTO;

import java.util.List;

public interface IAccountService {

    List<AccountResponseDTO> getAccounts();
    AccountResponseDTO saveAccount(AccountRequestDTO accountRequestDTO);
    AccountResponseDTO updateAccount(Long id, AccountRequestDTO accountRequestDTO);
    void deleteAccount(Long id);
    
}
