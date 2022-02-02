package com.fabio.vendas.controllers;

import com.fabio.vendas.dtos.ProdutoDto;
import com.fabio.vendas.models.Produto;
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
    public ResponseEntity<ProdutoDto> criar(@RequestBody ProdutoDto produtoDto) {

        return ResponseEntity.created(null).body(produtoService.criar(produtoDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizar(@RequestBody ProdutoDto produtoDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.atualizar(produtoDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<ProdutoDto> listar = produtoService.listar();
        return ResponseEntity.ok().body(listar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> obter(@PathVariable Long id) {
        ProdutoDto produtoDtoObtido = produtoService.obter(id);
        return ResponseEntity.ok().body(produtoDtoObtido);

    }
}
