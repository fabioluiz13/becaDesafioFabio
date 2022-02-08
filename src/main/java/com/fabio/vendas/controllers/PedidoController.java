package com.fabio.vendas.controllers;

import com.fabio.vendas.dtos.requests.PedidoRequest;
import com.fabio.vendas.dtos.responses.PedidoResponse;
import com.fabio.vendas.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@RequestBody PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = pedidoService.criar(pedidoRequest);
        return ResponseEntity.created(null).body(pedidoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizar(@RequestBody PedidoRequest pedidoRequest, @PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.atualizar(pedidoRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listar() {
        List<PedidoResponse> listaPedido = pedidoService.listar();
        return ResponseEntity.ok(listaPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> obter(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.obter(id));
    }
}