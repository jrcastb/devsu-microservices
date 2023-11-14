package com.microservices.clientservice.service;

import com.microservices.clientservice.dto.client.ClientRequestDTO;
import com.microservices.clientservice.dto.client.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    List<ClientResponseDTO> getClients();
    ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);
    void deleteClient(Long id);
    ClientResponseDTO getClientByName(String name);

}
