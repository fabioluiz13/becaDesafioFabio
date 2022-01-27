package com.fabio.vendas.controller;

import com.fabio.vendas.model.Pedido;
import com.fabio.vendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        Pedido pedidoCriado = pedidoService.criar(pedido);
        return ResponseEntity.created(null).body(pedidoCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido, @PathVariable Long id) {
        Pedido pedidoAtualizado = pedidoService.atualizar(pedido, id);
        return ResponseEntity.ok().body(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> listaPedido = pedidoService.listar();
        return ResponseEntity.ok().body(listaPedido);
    }

}