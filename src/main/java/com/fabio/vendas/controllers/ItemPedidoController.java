package com.fabio.vendas.controllers;

import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.models.ItemPedido;
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
        List<ItemPedido> pedidos = itemPedidoService.listar();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> obter(@PathVariable Long id){
        ItemPedido pedidoObtido = itemPedidoService.obter(id);
        return ResponseEntity.ok(pedidoObtido);
    }

}