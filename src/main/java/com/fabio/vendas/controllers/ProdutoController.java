package com.fabio.vendas.controllers;

import com.fabio.vendas.dtos.requests.ProdutoRequest;
import com.fabio.vendas.dtos.responses.ProdutoResponse;
import com.fabio.vendas.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.criar(produtoRequest);
        return ResponseEntity.created(null).body(produtoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest produtoRequest, @PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.atualizar(produtoRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar() {
        List<ProdutoResponse> listaProduto = produtoService.listar();
        return ResponseEntity.ok().body(listaProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> obter(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.obter(id));
    }
}
