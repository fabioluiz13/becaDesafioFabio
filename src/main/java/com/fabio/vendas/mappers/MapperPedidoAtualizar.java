package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.PedidoRequest;
import com.fabio.vendas.models.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperPedidoAtualizar {
    public void atualizar(PedidoRequest pedidoRequest, @MappingTarget Pedido pedido);
}
