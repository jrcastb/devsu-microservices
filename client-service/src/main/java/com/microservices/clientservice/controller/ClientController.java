package com.microservices.clientservice.controller;

import com.microservices.clientservice.dto.client.ClientRequestDTO;
import com.microservices.clientservice.dto.client.ClientResponseDTO;
import com.microservices.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getClients(){
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<ClientResponseDTO> saveClient(@RequestBody ClientRequestDTO clientRequestDTO){
        return new ResponseEntity<>(clientService.saveClient(clientRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO){
        return new ResponseEntity<>(clientService.updateClient(id, clientRequestDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
