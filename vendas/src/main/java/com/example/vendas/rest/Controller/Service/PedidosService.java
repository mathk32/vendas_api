package com.example.vendas.rest.Controller.Service;

import com.example.vendas.domain.entities.Pedidos;
import com.example.vendas.rest.Controller.DTO.PedidoDTO;

public interface PedidosService {
    Integer salvar(PedidoDTO pedido);
}
