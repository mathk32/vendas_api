package com.example.vendas.domain.repository;

import com.example.vendas.domain.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesR extends JpaRepository<Clientes, Integer> {
}
