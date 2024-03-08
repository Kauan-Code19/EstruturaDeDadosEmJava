package com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.controllers;

import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.dtos.ClientDTO;
import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.dtos.ClientResponseDTO;
import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.createClient(clientDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDTO.getId()).toUri();

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(clientDTO.getName(), clientDTO.getTelephone(),
                clientDTO.getEmail());

        return ResponseEntity.created(uri).body(clientResponseDTO);
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient) {
        clientService.deleteClient(idClient);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientResponseDTO> getClient (@PathVariable Long idCLient) {
        ClientDTO clientDTO = clientService.getClientHashService(idCLient);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(clientDTO.getName(), clientDTO.getTelephone(),
                clientDTO.getEmail());

        return ResponseEntity.ok().body(clientResponseDTO);
    }
}
