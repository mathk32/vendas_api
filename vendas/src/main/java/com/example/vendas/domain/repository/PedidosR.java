package com.example.vendas.domain.repository;

import com.example.vendas.domain.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosR extends JpaRepository<Pedidos,Integer> {
}
