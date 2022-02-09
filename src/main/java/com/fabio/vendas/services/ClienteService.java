package com.fabio.vendas.services;

import com.fabio.vendas.dtos.requests.ClienteResquest;
import com.fabio.vendas.dtos.responses.ClienteResponse;
import com.fabio.vendas.errors.ValidationException;
import com.fabio.vendas.mappers.MapperClienteRequestToCliente;
import com.fabio.vendas.mappers.MapperClienteAtualizar;
import com.fabio.vendas.mappers.MapperClienteToClienteResponse;
import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService  {

    private final ClienteRepository repository;
    private final MapperClienteRequestToCliente mapper;
    private final MapperClienteAtualizar clienteAtualizar;
    private final MapperClienteToClienteResponse mapperClienteToClienteResponse;

    public ClienteResponse criar(ClienteResquest clienteResquest) {
        Cliente cliente= mapper.toModel(clienteResquest);
        return mapperClienteToClienteResponse.toResponse(repository.save(cliente));
    }

    public ClienteResponse atualizar(ClienteResquest clienteResquest, Long id) {

        Cliente cliente = repository.findById(id).get();
        clienteAtualizar.atualizar(clienteResquest, cliente);
        return mapperClienteToClienteResponse.toResponse(repository.save(cliente));
    }

    public void deletar(Long id) {
            repository.deleteById(id);
    }

    public List<ClienteResponse> listar() {
        List<Cliente> listaClientes = repository.findAll();
        return listaClientes
                .stream()
                .map(mapperClienteToClienteResponse::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponse Obter(Long id) {
        Cliente cliente = repository.findById(id).get();
        return mapperClienteToClienteResponse.toResponse(cliente);
    }
}
