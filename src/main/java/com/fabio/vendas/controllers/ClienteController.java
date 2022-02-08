package com.fabio.vendas.controllers;


import com.fabio.vendas.dtos.requests.ClienteResquest;
import com.fabio.vendas.dtos.responses.ClienteResponse;
import com.fabio.vendas.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cliente")
public class ClienteController{

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> criar(@RequestBody @Validated ClienteResquest clienteResquest) {
        ClienteResponse clienteResponse = clienteService.criar(clienteResquest);
        return ResponseEntity.created(null).body(clienteResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@RequestBody ClienteResquest clienteResquest, @PathVariable Long id) {
        return ResponseEntity.ok().body(clienteService.atualizar(clienteResquest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        List<ClienteResponse> listaCliente = clienteService.listar();
        return ResponseEntity.ok().body(listaCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obter(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.Obter(id));
    }
}