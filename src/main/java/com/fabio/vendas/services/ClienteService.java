package com.fabio.vendas.services;

import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService  {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente) {
        Cliente clienteCriado = clienteRepository.save(cliente);
        return clienteCriado;
    }

    public Cliente atualizar(Cliente cliente, Long id) {
        Cliente obterCliente = this.Obter(id);
        obterCliente.setNome(cliente.getNome());
        obterCliente.setCpf(cliente.getCpf());
        obterCliente.setEndereco(cliente.getEndereco());
        Cliente cliente1 = clienteRepository.save(obterCliente);
        return cliente1;

    }

    public void deletar(Long id) {
      clienteRepository.deleteById(id);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();

    }
    public Cliente Obter (Long id){
        Optional<Cliente> obterCliente = clienteRepository.findById(id);
        return obterCliente.get();
    }
}
