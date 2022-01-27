package com.fabio.vendas.controller;


import com.fabio.vendas.model.Cliente;
import com.fabio.vendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente clienteCriado = clienteService.criar(cliente);
        return ResponseEntity.created(null).body(clienteCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteAtualizado = clienteService.atualizar(cliente, id);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> listaCliente = clienteService.listar();
        return ResponseEntity.ok().body(listaCliente);
    }

}