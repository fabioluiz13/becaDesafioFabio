package com.fabio.vendas.controller;


import com.fabio.vendas.model.Produto;
import com.fabio.vendas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> riar(@RequestBody Produto produto){
        Produto materiaCriada = produtoService.criar(produto);
        return ResponseEntity.created(null).body(materiaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Long id){
        Produto produtoAtualizado = produtoService.atualizar(produto, id);
        return  ResponseEntity.ok().body(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        List<Produto> listaProdutos = produtoService.listar();
        return  ResponseEntity.ok().body( listaProdutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obter(@PathVariable Long id){
       Produto produtoObtido =  produtoService.obter(id);
        return ResponseEntity.ok(produtoObtido);
    }
}
