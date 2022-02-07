package com.fabio.vendas.controllers;

import com.fabio.vendas.dtos.requests.ItemPedidoRequest;
import com.fabio.vendas.dtos.responses.ItemPedidoResponse;
import com.fabio.vendas.services.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/item")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoResponse> criar(@RequestBody ItemPedidoRequest itemPedidoRequest) {
       ItemPedidoResponse itemPedidoResponse = itemPedidoService.criar(itemPedidoRequest);
        return ResponseEntity.created(null).body(itemPedidoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoResponse> atualizar(@RequestBody ItemPedidoRequest itemPedidoRequest, @PathVariable Long id) {
        return ResponseEntity.ok().body(itemPedidoService.atualizar(itemPedidoRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponse>> listar() {
        List<ItemPedidoResponse>  listaItem = itemPedidoService.listar();
        return ResponseEntity.ok(listaItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponse> obter(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.obter(id));
    }

}