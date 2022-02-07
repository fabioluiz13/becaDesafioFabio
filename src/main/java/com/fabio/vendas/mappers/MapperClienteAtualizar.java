package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.ClienteResquest;
import com.fabio.vendas.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperClienteAtualizar {
    public void atualizar(ClienteResquest clienteResquest, @MappingTarget Cliente cliente);
}
