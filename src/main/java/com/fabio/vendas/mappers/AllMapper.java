//package com.fabio.vendas.mappers;
//
//import com.fabio.vendas.dtos.requests.ClienteResquest;
//import com.fabio.vendas.dtos.requests.PedidoRequest;
//import com.fabio.vendas.dtos.responses.ClienteResponse;
//import com.fabio.vendas.dtos.responses.PedidoResponse;
//import com.fabio.vendas.models.Cliente;
//import com.fabio.vendas.models.Pedido;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//
//@Mapper
//public interface AllMapper {
//
//    Cliente toModel(ClienteResquest clienteResquest);
//
//    public void atualizar(ClienteResquest clienteResquest, @MappingTarget Cliente cliente);
//
//    ClienteResponse toResponse(Cliente cliente);
//
//    public void atualizar(PedidoRequest pedidoRequest, @MappingTarget Pedido pedido);
//
//    PedidoResponse toResponse(Pedido pedido);
//
//    public Pedido toModel(PedidoRequest pedidoRequest);
//}
