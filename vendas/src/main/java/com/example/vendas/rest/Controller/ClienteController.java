package com.example.vendas.rest.Controller;

import com.example.vendas.domain.entities.Clientes;
import com.example.vendas.domain.repository.ClientesR;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;


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
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody Clientes cliente){
        clientes_repository.save(cliente);
        return cliente.getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Clientes cliente){
        clientes_repository.findById(id).map(cliente_encontrado -> {
            cliente.setId(cliente_encontrado.getId());
            clientes_repository.save(cliente);
            return cliente_encontrado;
        }).orElseThrow(() -> new RegraDeNegocios("Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientes_repository.findById(id).map(cliente_encontrado -> {
            clientes_repository.delete(cliente_encontrado);
            return cliente_encontrado;
        }).orElseThrow(() -> new RegraDeNegocios("Cliente não encontrado"));

    }

}