package com.fabio.vendas.services;//package com.fabio.vendas.services;

import com.fabio.vendas.dtos.requests.PedidoRequest;
import com.fabio.vendas.dtos.responses.PedidoResponse;
import com.fabio.vendas.mappers.MapperPedidoAtualizar;
import com.fabio.vendas.mappers.MapperPedidoRequestToPedido;
import com.fabio.vendas.mappers.MapperPedidoToPedidoResponse;
import com.fabio.vendas.models.Pedido;
import com.fabio.vendas.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MapperPedidoAtualizar pedidoAtualizar;
    private final MapperPedidoToPedidoResponse mapperPedidoToPedidoResponse;
    private final MapperPedidoRequestToPedido mapper;

    public PedidoResponse criar(PedidoRequest pedidoRequest) {
        Pedido pedido = mapper.toModel(pedidoRequest);
        return mapperPedidoToPedidoResponse.toResponse(pedidoRepository.save(pedido));
    }

    public PedidoResponse atualizar(PedidoRequest pedidoRequest, Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        pedidoAtualizar.atualizar(pedidoRequest, pedido);
        return mapperPedidoToPedidoResponse.toResponse(pedidoRepository.save(pedido));
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public List<PedidoResponse> listar() {
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        return listaPedidos
                .stream()
                .map(mapperPedidoToPedidoResponse::toResponse)
                .collect(Collectors.toList());
    }

    public PedidoResponse obter(Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return mapperPedidoToPedidoResponse.toResponse(pedido);
    }
}
