package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.responses.PedidoResponse;
import com.fabio.vendas.models.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPedidoToPedidoResponse {
    PedidoResponse toResponse(Pedido pedido);
}
