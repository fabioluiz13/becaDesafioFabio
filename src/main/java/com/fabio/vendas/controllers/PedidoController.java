package com.fabio.vendas.controllers;

import com.fabio.vendas.dtos.PedidoDto;
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
    public ResponseEntity<PedidoDto> criar(@RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.created(null).body(pedidoService.criar(pedidoDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizar(@RequestBody PedidoDto pedidoDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.atualizar(pedidoDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listar() {
        List<PedidoDto> listaObtida = pedidoService.listar();
        return ResponseEntity.ok().body(listaObtida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> obter(@PathVariable Long id){

        PedidoDto pedidoDtoObtido = pedidoService.obter(id);
        return ResponseEntity.ok().body(pedidoDtoObtido);
    }

}