package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.responses.ClienteResponse;
import com.fabio.vendas.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClienteToClienteResponse {
    public ClienteResponse toResponse(Cliente cliente);
}
