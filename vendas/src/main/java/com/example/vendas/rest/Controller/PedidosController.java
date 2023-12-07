package com.example.vendas.rest.Controller;


import static org.springframework.http.HttpStatus.*;

import com.example.vendas.rest.Controller.DTO.PedidoDTO;
import com.example.vendas.rest.Controller.Service.Imp.PedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



}
