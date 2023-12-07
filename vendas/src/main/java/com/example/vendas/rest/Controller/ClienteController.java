package com.example.vendas.rest.Controller;

import com.example.vendas.domain.entities.Clientes;
import com.example.vendas.domain.repository.ClientesR;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    ClientesR clientes_repository;

    @GetMapping("{id}")
    public Clientes find(@PathVariable Integer id){
        return clientes_repository.findById(id)
                .orElseThrow(() -> new RegraDeNegocios("Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes save(@RequestBody Clientes cliente){
        return clientes_repository.save(cliente);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Clientes cliente){
        clientes_repository.findById(id).map(cliente_encontrado -> {
            cliente.setId(cliente_encontrado.getId());
            clientes_repository.save(cliente);
            return cliente_encontrado;
        }).orElseThrow(() -> new RegraDeNegocios("Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientes_repository.findById(id).map(cliente_encontrado -> {
            clientes_repository.deleteById(id);
            return cliente_encontrado;
        }).orElseThrow(() -> new RegraDeNegocios("Cliente não encontrado"));

    }

}