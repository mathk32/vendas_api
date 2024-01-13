package com.example.vendas.rest.Controller.DTO;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InfitemPedidoDTO {
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;

}
