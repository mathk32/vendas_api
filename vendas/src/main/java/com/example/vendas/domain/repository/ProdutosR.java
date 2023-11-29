package com.example.vendas.domain.repository;

import com.example.vendas.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosR extends JpaRepository<Produto,Integer> {
}
