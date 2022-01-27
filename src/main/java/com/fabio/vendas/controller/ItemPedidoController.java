package com.fabio.vendas.controller;

import com.fabio.vendas.model.ItemPedido;
import com.fabio.vendas.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedido> Criar(@RequestBody ItemPedido itemPedido) {
        ItemPedido itemCriado = itemPedidoService.Criar(itemPedido);
        return ResponseEntity.created(null).body(itemCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizar(@RequestBody ItemPedido itemPedido, @PathVariable Long id) {
        ItemPedido itemAtualizado = itemPedidoService.atualizar(itemPedido, id);
        return ResponseEntity.ok().body(itemAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        itemPedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listar() {
        List<ItemPedido> listaItem = itemPedidoService.listar();
        return ResponseEntity.ok().body(listaItem);
    }

}