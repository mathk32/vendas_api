package com.example.vendas.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    private LocalDate data;
    private float total;
    @OneToMany(mappedBy = "pedido")
    private List<itemPedido> itens;
}
