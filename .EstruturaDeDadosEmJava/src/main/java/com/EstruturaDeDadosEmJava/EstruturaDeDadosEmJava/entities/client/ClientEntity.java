package com.EstruturaDeDadosEmJava.EstruturaDeDadosEmJava.entities.client;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
@EqualsAndHashCode
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
