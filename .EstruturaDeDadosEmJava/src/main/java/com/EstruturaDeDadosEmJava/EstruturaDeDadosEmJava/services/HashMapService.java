package com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.services;

import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.entities.client.ClientEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class HashMapService {

    private final Map<String, ClientEntity> tableHashClient = new HashMap<>();

    @Transactional
    public void addClientHashTable(ClientEntity clientEntity) {
        tableHashClient.put(clientEntity.getCpf(), clientEntity);
    }

    @Transactional
    public ClientEntity getClientHashTable(String cpfClient) {
        return tableHashClient.get(cpfClient);
    }

    @Transactional
    public void deleteClientHashTable(String cpfClient) {
        tableHashClient.remove(cpfClient);
    }
}
