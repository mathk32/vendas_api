package com.example.vendas.rest.Controller.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfitemPedidoDTO {
    private String descricao;
    private float preco;
    private int quantidade;

}
