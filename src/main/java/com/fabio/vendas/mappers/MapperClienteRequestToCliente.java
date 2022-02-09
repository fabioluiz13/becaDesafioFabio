package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.ClienteResquest;
import com.fabio.vendas.models.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClienteRequestToCliente {
   public Cliente toModel(ClienteResquest clienteResquest);
}
