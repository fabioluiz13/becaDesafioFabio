package com.fabio.vendas.controllers;

import com.fabio.vendas.dtos.ItemPedidoDto;
import com.fabio.vendas.dtos.PedidoDto;
import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.models.ItemPedido;
import com.fabio.vendas.services.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/item")
public class ItemPedidoController {


    private final ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoDto> criar(@RequestBody ItemPedidoDto itemPedidoDto) {
        return ResponseEntity.created(null).body(itemPedidoService.criar(itemPedidoDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> atualizar(@RequestBody ItemPedidoDto itemPedidoDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(itemPedidoService.atualizar(itemPedidoDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoDto>> listar() {
        List<ItemPedidoDto> listaDto = itemPedidoService.listar();
        return ResponseEntity.ok().body(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> obter(@PathVariable Long id) {
        ItemPedidoDto itemPedido = itemPedidoService.obter(id);
        return ResponseEntity.ok().body(itemPedido);
    }

}