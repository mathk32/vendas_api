package com.example.vendas.rest.Controller.Service.Imp;

import com.example.vendas.domain.entities.Clientes;
import com.example.vendas.domain.entities.Pedidos;
import com.example.vendas.domain.entities.Produto;
import com.example.vendas.domain.entities.enums.Status;
import com.example.vendas.domain.entities.itemPedido;
import com.example.vendas.domain.repository.ClientesR;
import com.example.vendas.domain.repository.PedidosR;
import com.example.vendas.domain.repository.ProdutosR;
import com.example.vendas.domain.repository.itemPedidoR;
import com.example.vendas.rest.Controller.DTO.PedidoDTO;
import com.example.vendas.rest.Controller.DTO.itemPedidoDTO;
import com.example.vendas.rest.Controller.Service.PedidosService;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidosServiceImpl implements PedidosService {


    private final PedidosR pedidos_repository;
    private final ClientesR clientes_repository;
    private final ProdutosR produtos_repository;
    private final itemPedidoR itens_repository;


    @Override
    @Transactional
    public Integer salvar(PedidoDTO pedido) {
       Pedidos pedidos = new Pedidos();
       Clientes cliente = clientes_repository.findById(pedido.getId_cliente())
                       .orElseThrow(() -> new RegraDeNegocios("Cliente não encontrado."));
       pedidos.setTotal(pedido.getTotal());
       pedidos.setData(LocalDate.now());
       pedidos.setCliente(cliente);
       pedidos.setStatus(Status.REALIZADO);
       List<itemPedido> itens_pedidos= converter_itens(pedidos, pedido.getItens());
       pedidos_repository.save(pedidos);
       itens_repository.saveAll(itens_pedidos);

        return pedidos.getId();

    }

    @Override
    public Optional<Pedidos> obter_pedido(Integer id) {
        return pedidos_repository.findById(id);
    }

    @Override
    public void atualizar_pedido(Integer id, Status status) {
        pedidos_repository.findById(id).map(
                pedido -> {
                    pedido.setStatus(status);
                    pedidos_repository.save(pedido);
                    return pedido;
                }
        ).orElseThrow(() -> new RegraDeNegocios("Pedido não encontrado."));
    }

    public List<itemPedido> converter_itens(Pedidos pedido, List<itemPedidoDTO> itens){
        return itens.stream().map(itempedido_dto -> {
            itemPedido itempedido = new itemPedido();
            Produto produto = produtos_repository.findById(itempedido_dto.getId_produto())
                            .orElseThrow(() -> new RegraDeNegocios("Produto não encontrado."));
            itempedido.setPedido(pedido);
            itempedido.setProduto(produto);
            itempedido.setQuantidade(itempedido_dto.getQuantidade());
            return itempedido;
        }).collect(Collectors.toList());

    }
}
