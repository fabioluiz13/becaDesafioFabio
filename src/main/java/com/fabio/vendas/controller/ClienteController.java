package com.fabio.vendas.controller;


import com.fabio.vendas.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {



    @PostMapping
    public ResponseEntity<Cliente> Criar(@RequestBody Cliente cliente) {

        cliente.setId(1L);
        return ResponseEntity.created(null).body(cliente);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
        cliente.setId(id);
        return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {

        Cliente cliente1 =  new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Fabio");
        cliente1.setCpf("111.222.333-99");
        cliente1.setEndereco("Rua Japão");

        Cliente cliente2 =  new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Ester");
        cliente2.setCpf("222.333.444-99");
        cliente2.setEndereco("Rua Acre");

        Cliente cliente3 =  new Cliente();
        cliente3.setId(3L);
        cliente3.setNome("Aguiar");
        cliente3.setCpf("333.444.555-99");
        cliente3.setEndereco("Rua Fortaleza");

        return ResponseEntity.ok().body(List.of(cliente1, cliente2, cliente3));
    }

}