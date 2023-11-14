package com.microservices.clientservice.unit.controller;

import com.microservices.clientservice.controller.ClientController;
import com.microservices.clientservice.dto.client.ClientRequestDTO;
import com.microservices.clientservice.service.ClientService;
import com.microservices.clientservice.util.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @Mock
    ClientService clientService;
    @InjectMocks
    ClientController clientController;

    @Test
    @DisplayName("obtener todos los clientes registrados")
    void getClientsTest(){
        //arrange

        //act
        clientController.getClients();

        verify(clientService, atLeastOnce()).getClients();
    }

    @Test
    @DisplayName("obtener todos los clientes registrados")
    void saveClientTest(){
        //arrange
        ClientRequestDTO clientRequestDTO = TestUtilGenerator.getClientRequestDTO();
        //act
        clientController.saveClient(clientRequestDTO);

        verify(clientService, atLeastOnce()).saveClient(clientRequestDTO);
    }
}
