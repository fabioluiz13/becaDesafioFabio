package com.fabio.vendas.services;

import com.fabio.vendas.dtos.requests.ItemPedidoRequest;
import com.fabio.vendas.dtos.responses.ItemPedidoResponse;
import com.fabio.vendas.mappers.MapperItemPedidoAtualizar;
import com.fabio.vendas.mappers.MapperItemToItemPedidoResponse;
import com.fabio.vendas.mappers.MapperItemToRequestItemPedido;
import com.fabio.vendas.models.ItemPedido;
import com.fabio.vendas.repositories.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final MapperItemToItemPedidoResponse pedidoResponse;
    private final MapperItemToRequestItemPedido itemToRequestItemPedido;
    private final MapperItemPedidoAtualizar itemPedidoAtualizar;

    public ItemPedidoResponse criar(ItemPedidoRequest pedidoRequest) {
        ItemPedido pedido = itemToRequestItemPedido.toModel(pedidoRequest);
        return pedidoResponse.toResponse( itemPedidoRepository.save(pedido));
    }

    public ItemPedidoResponse atualizar( ItemPedidoRequest pedidoRequest, Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
        itemPedidoAtualizar.atulaizar(pedidoRequest, itemPedido);
        return pedidoResponse.toResponse(itemPedidoRepository.save(itemPedido));
    }

    public void deletar( Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public List<ItemPedidoResponse> listar() {
        List<ItemPedido> listaItem = itemPedidoRepository.findAll();
        return listaItem
                .stream()
                .map(pedidoResponse::toResponse)
                .collect(Collectors.toList());
    }

    public ItemPedidoResponse obter(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
        return pedidoResponse.toResponse(itemPedido);

    }
}
