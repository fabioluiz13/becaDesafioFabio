package com.fabio.vendas.services;

import com.fabio.vendas.dtos.ItemPedidoDto;
import com.fabio.vendas.models.ItemPedido;
import com.fabio.vendas.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoDto criar(ItemPedidoDto pedidoDto) {
        ItemPedido pedido = new ItemPedido(pedidoDto);
        return  new ItemPedidoDto(itemPedidoRepository.save(pedido));
    }


    public ItemPedidoDto atualizar( ItemPedidoDto itemPedidoDto, Long id) {
        return new ItemPedidoDto(itemPedidoRepository.findById(id)
                .map(itemPedido -> itemPedidoRepository.save(new ItemPedido(itemPedidoDto)))
                .orElseThrow(ResolutionException::new));
    }

    public void deletar( Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public List<ItemPedidoDto> listar() {
        List<ItemPedidoDto> itemPedidoDtos = new ArrayList<>();
        List<ItemPedido> listaProduto = itemPedidoRepository.findAll();
        listaProduto.stream().forEach(item -> itemPedidoDtos.add(new ItemPedidoDto(item)));

        return itemPedidoDtos;
    }

    public ItemPedidoDto obter(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
        return new ItemPedidoDto(itemPedido);

    }
}
