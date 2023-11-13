package com.microservices.accountservice.controller;

import com.microservices.accountservice.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Mock
    IAccountService service;

    @InjectMocks
    AccountController controller;

    @Test
    public void createOrder(){
        /*
        //arrange
        List<AccountDTO> orderLineItems = new ArrayList<>();
        AccountDTO orderLineItem = AccountDTO.builder()
                .skuCode("teclado")
                .price(BigDecimal.valueOf(130000))
                .quantity(1)
                .build();
        AccountRequest order = AccountRequest.builder()
                .orderLineItemsDTO(orderLineItems)
                .build();
        //action
        controller.placeOrder(order);

        //assert
        verify(service, atLeastOnce()).placeOrder(order);*/
    }
}
