package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.ItemPedidoRequest;
import com.fabio.vendas.models.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperItemPedidoAtualizar {
    public void atulaizar(ItemPedidoRequest pedidoRequest, @MappingTarget ItemPedido pedido);
}
