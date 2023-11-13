package com.microservices.clientservice.service;

import com.microservices.clientservice.dto.ClientRequestDTO;
import com.microservices.clientservice.dto.ClientResponseDTO;
import com.microservices.clientservice.model.Client;
import com.microservices.clientservice.repository.ClientRepository;
import com.microservices.clientservice.repository.PersonRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    //@Transactional(readOnly = true)

    @Override
    public List<ClientResponseDTO> getClients() {
        List<Client> clients;

        clients = clientRepository.findAll();

        return clients.stream().map(this::mapToResponse).toList();
    }

    @Override
    public ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO response;
        Client client = mapToClient(clientRequestDTO);
        clientRepository.save(client);
        response = mapToResponse(client);
        return response;
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Optional<Client> clientData = clientRepository.findById(id);
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        if(clientData.isPresent()){
            Client client = clientData.get();
            client.setName(clientRequestDTO.getName());
            client.setGender(clientRequestDTO.getGender());
            client.setAge(clientRequestDTO.getAge());
            client.setIdentification(clientRequestDTO.getIdentification());
            client.setAddress(clientRequestDTO.getAddress());
            client.setPhoneNumber(clientRequestDTO.getPhoneNumber());
            client.setClientId(clientRequestDTO.getClientId());
            client.setPassword(clientRequestDTO.getPassword());
            client.setStatus(clientRequestDTO.getStatus());
            clientRepository.save(client);
            clientResponseDTO = mapToResponse(client);
        }

        return clientResponseDTO;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


    private ClientResponseDTO mapToResponse(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .gender(client.getGender())
                .age(client.getAge())
                .identification(client.getIdentification())
                .address(client.getAddress())
                .phoneNumber(client.getPhoneNumber())
                .clientId(client.getClientId())
                .status(client.getStatus())
                .build();
    }

    private Client mapToClient(ClientRequestDTO clientRequestDTO) {
        return Client.clientBuilder()
                .name(clientRequestDTO.getName())
                .gender(clientRequestDTO.getGender())
                .age(clientRequestDTO.getAge())
                .identification(clientRequestDTO.getIdentification())
                .address(clientRequestDTO.getAddress())
                .phoneNumber(clientRequestDTO.getPhoneNumber())
                .clientId(clientRequestDTO.getClientId())
                .password(clientRequestDTO.getPassword())
                .status(clientRequestDTO.getStatus())
                .build();
    }


}
