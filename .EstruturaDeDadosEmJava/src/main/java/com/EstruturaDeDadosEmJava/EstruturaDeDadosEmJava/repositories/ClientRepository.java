package com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.repositories;

import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.entities.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
