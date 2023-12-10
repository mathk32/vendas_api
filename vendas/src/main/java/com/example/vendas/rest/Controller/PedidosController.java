package com.example.vendas.rest.Controller;


import static org.springframework.http.HttpStatus.*;

import com.example.vendas.domain.entities.Pedidos;
import com.example.vendas.domain.entities.enums.Status;
import com.example.vendas.domain.entities.itemPedido;
import com.example.vendas.rest.Controller.DTO.AtualizacaPedidoStatusDTO;
import com.example.vendas.rest.Controller.DTO.InfPedidoDTO;
import com.example.vendas.rest.Controller.DTO.InfitemPedidoDTO;
import com.example.vendas.rest.Controller.DTO.PedidoDTO;
import com.example.vendas.rest.Controller.Service.Imp.PedidosServiceImpl;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    PedidosServiceImpl service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO pedido){
        return service.salvar(pedido);
    }


    @GetMapping("{id}")
    public InfPedidoDTO get_pedido(@PathVariable Integer id){
        return service.obter_pedido(id).map(pedido -> converter(pedido))
                .orElseThrow(() -> new RegraDeNegocios("Pedido não encontrado."));
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update_status(@PathVariable Integer id, @RequestBody AtualizacaPedidoStatusDTO status){
        String new_status = status.getStatus();
        service.atualizar_pedido(id, Status.valueOf(new_status));
    }


    private InfPedidoDTO converter(Pedidos pedido) {
        return InfPedidoDTO.builder().codigo_pedido(pedido.getId())
                .nome_cliente(pedido.getCliente().getNome())
                .cpf(pedido.getCliente().getCpf())
                .data(pedido.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .status(pedido.getStatus().name())
                .total(pedido.getTotal())
                .itens(converter_itemPedido(pedido.getItens())).build();
    }

    private List<InfitemPedidoDTO> converter_itemPedido(List<itemPedido> itens) {
        return itens.stream().map(item -> InfitemPedidoDTO.builder()
                .descricao(item.getProduto().getDescricao())
                .preco(item.getProduto().getPreco())
                .quantidade(item.getQuantidade()).build()).collect(Collectors.toList());
    }

}
