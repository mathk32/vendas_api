package com.example.vendas.rest.Controller.DTO;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InfPedidoDTO {
    private Integer codigo_pedido;
    private String nome_cliente;
    private String cpf;
    private String data;
    private List<InfitemPedidoDTO> itens;
    private float total;
    private String status;
}



