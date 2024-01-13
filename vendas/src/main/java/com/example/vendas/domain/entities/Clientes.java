package com.example.vendas.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "{campo.nome-cliente.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.cpf-cliente.obrigatorio}")
    @CPF(message = "{campo.cpf-cliente.valido}")
    private String cpf;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedidos> pedidos;

}
