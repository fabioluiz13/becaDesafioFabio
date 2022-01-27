package com.fabio.vendas.services;

import com.fabio.vendas.model.ItemPedido;
import com.fabio.vendas.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemPedidoService {

    public ItemPedido Criar(ItemPedido itemPedido) {
        itemPedido.setId(3L);
        return itemPedido;
    }

    public ItemPedido atualizar(ItemPedido itemPedido, Long id) {
        itemPedido.setId(id);
        return itemPedido;
    }

    public void deletar( Long id) {
       //
    }

    public List<ItemPedido> listar() {

        Produto produto1 = new Produto();
        produto1.setId(1L);
        produto1.setDescricao("Arroz Parborizado");
        produto1.setPreco(14.99);

        Produto produto2 = new Produto();
        produto2.setId(1L);
        produto2.setDescricao("Arroz Integral");
        produto2.setPreco(19.99);

        Produto produto3 = new Produto();
        produto3.setId(1L);
        produto3.setDescricao("Arroz Aguilinha");
        produto3.setPreco(22.56);

        ItemPedido pedido1 = new ItemPedido();
        pedido1.setId(4L);
        pedido1.setPreco(12.55);
        pedido1.setQuantidade(2);
        pedido1.setProduto(produto3);

        ItemPedido pedido2 = new ItemPedido();
        pedido2.setId(5L);
        pedido2.setPreco(20.99);
        pedido2.setQuantidade(4);
        pedido2.setProduto(produto2);

        ItemPedido pedido3 = new ItemPedido();
        pedido3.setId(6L);
        pedido3.setPreco(8.56);
        pedido3.setQuantidade(10);
        pedido3.setProduto(produto1);

        return List.of(pedido1, pedido2, pedido3);
    }
}
