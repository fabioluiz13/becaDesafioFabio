package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.ItemPedidoRequest;
import com.fabio.vendas.models.ItemPedido;
import org.mapstruct.Mapper;

@Mapper
public interface MapperItemToRequestItemPedido {
    public ItemPedido toModel(ItemPedidoRequest pedidoRequest);
}
