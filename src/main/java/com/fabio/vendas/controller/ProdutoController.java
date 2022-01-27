package com.fabio.vendas.controller;


import com.fabio.vendas.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @PostMapping
    public ResponseEntity<Produto> Criar(@RequestBody Produto produto){

        produto.setId(1L);
        return ResponseEntity.created(null).body(produto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Long id){
        produto.setId(id);
        return  ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return ResponseEntity.noContent().build();    //("Requesição de deletou " + id) ;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){

        Produto prod1 = new Produto();
        prod1.setId(2L);
        prod1.setDescricao("Arroz");
        prod1.setPreco(15.89);

        Produto prod2 = new Produto();
        prod2.setId(3L);
        prod2.setDescricao("Feijão");
        prod2.setPreco(7.56);

        Produto prod3 = new Produto();
        prod3.setId(4L);
        prod3.setDescricao("Oleo");
        prod3.setPreco(8.99);

        return  ResponseEntity.ok().body( List.of(prod1, prod2, prod3));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obter(@PathVariable Long id){
        Produto prod1 = new Produto();
        prod1.setId(id);
        prod1.setDescricao("Arroz");
        prod1.setPreco(15.89);

        return ResponseEntity.ok(prod1);
    }
}
