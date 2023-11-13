package com.microservices.accountservice.controller;

import com.microservices.accountservice.dto.AccountRequestDTO;
import com.microservices.accountservice.dto.AccountResponseDTO;
import com.microservices.accountservice.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class AccountController {
    
    private final IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAccounts(){
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<AccountResponseDTO> saveAccount(@RequestBody AccountRequestDTO accountRequestDTO){

        return new ResponseEntity<>(accountService.saveAccount(accountRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable Long id, @RequestBody AccountRequestDTO accountRequestDTO){
        return new ResponseEntity<>(accountService.updateAccount(id, accountRequestDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
