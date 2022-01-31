package com.fabio.vendas.controllers;

import com.fabio.vendas.models.Pedido;
import com.fabio.vendas.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {


    private final PedidoService pedidoService;

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
        List<Pedido> pedidos = pedidoService.listar();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obter(@PathVariable Long id){
        Pedido pedidoObtido = pedidoService.obter(id);
        return ResponseEntity.ok(pedidoObtido);
    }

}