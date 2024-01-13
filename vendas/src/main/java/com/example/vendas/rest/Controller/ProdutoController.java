package com.example.vendas.rest.Controller;

import com.example.vendas.domain.entities.Produto;
import com.example.vendas.domain.repository.ProdutosR;

import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutosR produtos_repository;

    @GetMapping("{id}")
    public Produto find(@PathVariable Integer id){
        return produtos_repository.findById(id)
                .orElseThrow(() -> new RegraDeNegocios("Produto não encontrado."));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save( @Valid @RequestBody Produto produto) {
        produtos_repository.save(produto);
        return produto.getId();
    }


    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @Valid @RequestBody Produto produto){
        produtos_repository.findById(id).map(produto_encontrado -> {
            produto.setId(produto_encontrado.getId());
            produtos_repository.save(produto);
            return produto_encontrado;
        }).orElseThrow(() -> new RegraDeNegocios("Produto não encontrado."));
    }


    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        produtos_repository.findById(id).map(produto_encontrado -> {
            produtos_repository.delete(produto_encontrado);
            return produto_encontrado;
        }).orElseThrow(() -> new RegraDeNegocios("Produto não encontrado."));
    }


}
