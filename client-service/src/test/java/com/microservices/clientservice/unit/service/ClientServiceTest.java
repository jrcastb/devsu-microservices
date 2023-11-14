package com.microservices.clientservice.unit.service;

import com.microservices.clientservice.dto.client.ClientRequestDTO;
import com.microservices.clientservice.dto.client.ClientResponseDTO;
import com.microservices.clientservice.model.Client;
import com.microservices.clientservice.repository.ClientRepository;
import com.microservices.clientservice.service.impl.ClientServiceImpl;
import com.microservices.clientservice.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    @DisplayName("obtener todos los clientes registrados")
    void getClientsTest(){

        List<Client> clients = TestUtilGenerator.getClients();

        when(clientRepository.findAll()).thenReturn(clients);

        List<ClientResponseDTO> actual = clientService.getClients();
        List<ClientResponseDTO> expected = clients.stream().map(TestUtilGenerator::mapToClientResponse).toList();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("registrar un cliente")
    void saveClientTest(){
        ClientRequestDTO clientRequestDTO = TestUtilGenerator.getClientRequestDTO();
        Client client = TestUtilGenerator.getClient();

        when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);

        ClientResponseDTO actual = clientService.saveClient(clientRequestDTO);
        ClientResponseDTO expected = TestUtilGenerator.mapToClientResponse(client);

        Assertions.assertEquals(expected.getName(), actual.getName());
    }

}
