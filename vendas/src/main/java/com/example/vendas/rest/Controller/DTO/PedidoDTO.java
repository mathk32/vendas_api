package com.example.vendas.rest.Controller.DTO;

import com.example.vendas.domain.entities.enums.Status;
import com.example.vendas.rest.valiation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    @NotNull(message = "{campo.cliente-pedido.obrigatorio}")
    private Integer id_cliente;
    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;
    @NotEmptyList(message = "{campo.lista-pedido.obrigatorio}")
    private List<itemPedidoDTO> itens;
}
