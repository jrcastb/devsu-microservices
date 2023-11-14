package com.microservices.clientservice.util;

import com.microservices.clientservice.dto.client.ClientRequestDTO;
import com.microservices.clientservice.dto.client.ClientResponseDTO;
import com.microservices.clientservice.model.Client;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    public static List<Client> getClients(){
        List<Client> clients = new ArrayList<>();
        Client client = Client.clientBuilder()
                .id(1L)
                .name("Jose Castillo")
                .age(27)
                .gender(true)
                .identification("1065825816")
                .address("Av siempre viva 123")
                .phoneNumber("3116783489")
                .password("doom")
                .clientId("1")
                .status(true)
                .build();
        clients.add(client);
        return clients;
    }
    public static Client getClient(){
        return Client.clientBuilder()
                .id(1L)
                .name("Jose Castillo")
                .age(27)
                .gender(true)
                .identification("1065825816")
                .address("Av siempre viva 123")
                .phoneNumber("3116783489")
                .password("doom")
                .clientId("1")
                .status(true)
                .build();
    }
    public static ClientResponseDTO mapToClientResponse(Client client){
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

    public static ClientRequestDTO getClientRequestDTO() {
        return ClientRequestDTO.builder()
                .name("Jose Castillo")
                .gender(true)
                .age(27)
                .identification("1065825816")
                .address("Av siempre viva 123")
                .phoneNumber("3116783489")
                .password("doom")
                .clientId("1")
                .status(true)
                .build();
    }
}
