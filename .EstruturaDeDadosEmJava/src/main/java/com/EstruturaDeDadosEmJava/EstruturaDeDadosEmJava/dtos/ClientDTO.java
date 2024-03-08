package com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.dtos;

import com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.entities.client.ClientEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ClientDTO {
    private String name;
    private String cpf;
    private String telephone;
    private String email;

    public ClientDTO(ClientEntity entity) {
        name = entity.getName();
        cpf = entity.getCpf();
        telephone = entity.getTelephone();
        email = entity.getEmail();
    }
}
