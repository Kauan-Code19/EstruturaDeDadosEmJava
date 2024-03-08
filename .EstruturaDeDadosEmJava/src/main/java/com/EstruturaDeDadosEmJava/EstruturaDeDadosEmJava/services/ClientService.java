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
    private final HashMapService hashMapService;

    @Autowired
    public ClientService(ClientRepository clientRepository, HashMapService hashMapService) {
        this.clientRepository = clientRepository;
        this.hashMapService = hashMapService;
    }

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        ClientEntity entity = new ClientEntity();

        entity.setName(clientDTO.getName());
        entity.setCpf(clientDTO.getCpf());
        entity.setTelephone(clientDTO.getTelephone());
        entity.setEmail(clientDTO.getEmail());

        entity = clientRepository.save(entity);

        hashMapService.addClientHashTable(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);

        ClientEntity entity = clientRepository.getReferenceById(idClient);

        hashMapService.deleteClientHashTable(entity.getCpf());
    }

    @Transactional
    public ClientDTO getClientHashService(Long idCLient) {
        ClientEntity clientEntityReference = clientRepository.getReferenceById(idCLient);

        ClientEntity clientEntity =  hashMapService.getClientHashTable(clientEntityReference.getCpf());

        return  new ClientDTO(clientEntity);
    }

}
