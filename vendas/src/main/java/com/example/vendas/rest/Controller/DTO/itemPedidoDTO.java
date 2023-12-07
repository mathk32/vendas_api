package com.example.vendas.rest.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class itemPedidoDTO {

    private Integer id_produto;
    private Integer id_pedido;
    private int quantidade;

}



