package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.responses.ItemPedidoResponse;
import com.fabio.vendas.models.ItemPedido;
import org.mapstruct.Mapper;

@Mapper
public interface MapperItemToItemPedidoResponse {
    public ItemPedidoResponse toResponse(ItemPedido itemPedido);
}
