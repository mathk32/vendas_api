package com.example.vendas.rest.Controller.Service;

import com.example.vendas.domain.entities.Pedidos;
import com.example.vendas.domain.entities.enums.Status;
import com.example.vendas.rest.Controller.DTO.PedidoDTO;

import java.util.Optional;

public interface PedidosService {
    Integer salvar(PedidoDTO pedido);
    Optional<Pedidos> obter_pedido(Integer id);
    void atualizar_pedido(Integer id, Status status);
}
