package com.fabio.vendas.services;

import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente criar(Cliente cliente) {
        Cliente clientesalvo = repository.save(cliente);
        return clientesalvo;
    }

    public Cliente atualizar(Cliente cliente, Long id) {
        Cliente clienteObtido = this.Obter(id);
        clienteObtido.setNome(cliente.getNome());
        clienteObtido.setCpf(cliente.getCpf());
        clienteObtido.setEndereco(cliente.getEndereco());
        repository.save(clienteObtido);
        return clienteObtido;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente Obter(Long id) {
        Cliente cliente = repository.findById(id).get();
        return cliente;
    }
}
