package com.example.vendas.domain.entities;

import com.example.vendas.domain.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    private LocalDate data;
    private BigDecimal total;
    private Status status;
    @OneToMany(mappedBy = "pedido")
    private List<itemPedido> itens;
}
