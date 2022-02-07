package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.PedidoRequest;
import com.fabio.vendas.models.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPedidoRequestToPedido {
    public Pedido toModel(PedidoRequest pedidoRequest);
}
