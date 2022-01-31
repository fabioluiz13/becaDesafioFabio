package com.fabio.vendas.services;

import com.fabio.vendas.models.ItemPedido;
import com.fabio.vendas.models.Produto;
import com.fabio.vendas.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido Criar(ItemPedido itemPedido) {
        Produto produtoObtido = produtoService.obter(itemPedido.getProduto().getId());
        itemPedido.setProduto(produtoObtido);
        ItemPedido itemPedidoCriado  = itemPedidoRepository.save(itemPedido);
        return itemPedidoCriado;
    }

    public ItemPedido atualizar(ItemPedido itemPedido, Long id) {
        ItemPedido itemPedidoObtido = this.obter(id);
        itemPedidoObtido.setProduto(itemPedido.getProduto());
        itemPedidoObtido.setQuantidade(itemPedido.getQuantidade());
        itemPedidoObtido.setPreco(itemPedido.getPreco());
        itemPedidoRepository.save(itemPedidoObtido);
        return itemPedidoObtido;
    }

    public void deletar( Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public List<ItemPedido> listar() {
        List<ItemPedido> listaItem = itemPedidoRepository.findAll();
        return listaItem;
    }


    public ItemPedido obter(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
        return itemPedido;
    }
}
