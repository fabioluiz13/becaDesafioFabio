package com.fabio.vendas.controllers;


import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.services.ClienteService;
import com.fabio.vendas.validations.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController extends Validacao {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody @Valid Cliente cliente) {
        Validacao validacao =new Validacao();
        return ResponseEntity.created(null).body(clienteService.criar(cliente));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteAtualizado = clienteService.atualizar(cliente, id);
        return ResponseEntity.ok().body(clienteAtualizado);
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