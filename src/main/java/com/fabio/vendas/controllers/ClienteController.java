package com.fabio.vendas.controllers;


import com.fabio.vendas.dtos.requests.ClienteResquest;
import com.fabio.vendas.dtos.responses.ClienteResponse;
import com.fabio.vendas.errors.ValidationException;
import com.fabio.vendas.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cliente")
public class ClienteController  {

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
    public ResponseEntity<ClienteResponse> obter(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.Obter(id));
    }
}