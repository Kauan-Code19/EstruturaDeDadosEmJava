package com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.services;

import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.dtos.ClientDTO;
import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.entities.client.ClientEntity;
import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        ClientEntity entity = new ClientEntity();

        entity.setName(clientDTO.getName());
        entity.setCpf(clientDTO.getCpf());
        entity.setTelephone(clientDTO.getTelephone());
        entity.setEmail(clientDTO.getEmail());

        entity = clientRepository.save(entity);

        return new ClientDTO(entity);
    }
}
