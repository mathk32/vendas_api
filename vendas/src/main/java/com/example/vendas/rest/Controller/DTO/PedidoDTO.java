package com.example.vendas.rest.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Integer id_cliente;
    private float total;
    private List<itemPedidoDTO> itens;
}
