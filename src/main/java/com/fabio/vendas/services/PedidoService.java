package com.fabio.vendas.services;

import com.fabio.vendas.model.Cliente;
import com.fabio.vendas.model.ItemPedido;
import com.fabio.vendas.model.Pedido;
import com.fabio.vendas.model.Produto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    public Pedido criar( Pedido pedido) {
        pedido.setId(2L);
        return pedido;
    }

    public Pedido atualizar( Pedido pedido, Long id) {
        pedido.setId(id);
        return pedido;
    }

    public void deletar( Long id) {
        //
    }

    public List<Pedido> listar() {


        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("fabio");
        cliente1.setCpf("111.222.333-99");
        cliente1.setEndereco("Rua Acre");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Ester");
        cliente2.setCpf("222.333.444-88");
        cliente2.setEndereco("Rua Fortaleza");

        Cliente cliente3 = new Cliente();
        cliente3.setId(3L);
        cliente3.setNome("Sarah");
        cliente3.setCpf("333.444.555-77");
        cliente3.setEndereco("Rua João da mata");

        Produto produto1 = new Produto();
        produto1.setId(1L);
        produto1.setDescricao("Arroz Parborizado");
        produto1.setPreco(16.78);

        Produto produto2 = new Produto();
        produto2.setId(2L);
        produto2.setDescricao("Arroz Agulinha");
        produto2.setPreco(11.55);

        Produto produto3 = new Produto();
        produto3.setId(1L);
        produto3.setDescricao("Arroz Integral");
        produto3.setPreco(23.89);

        ItemPedido item1 = new ItemPedido();
        item1.setId(1L);
        item1.setPreco(20.50);
        item1.setQuantidade(3);
        item1.setProduto(produto1);

        ItemPedido item2 = new ItemPedido();
        item2.setId(2L);
        item2.setPreco(10.50);
        item2.setQuantidade(5);
        item2.setProduto(produto2);

        ItemPedido item3 = new ItemPedido();
        item3.setId(3L);
        item3.setPreco(30.00);
        item3.setQuantidade(7);
        item3.setProduto(produto3);

        Pedido pedido1 = new Pedido();
        pedido1.setId(2L);
        pedido1.setData(LocalDate.of(2020, 8, 25));
        pedido1.setItems(List.of(item1));
        pedido1.setCliente(cliente1);

        Pedido pedido2 = new Pedido();
        pedido2.setId(3L);
        pedido2.setData(LocalDate.of(2020, 8, 12));
        pedido2.setItems(List.of(item2));
        pedido2.setCliente(cliente2);

        Pedido pedido3 = new Pedido();
        pedido3.setId(4L);
        pedido3.setData(LocalDate.of(2021, 12, 13));
        pedido3.setItems(List.of(item3));
        pedido3.setCliente(cliente3);

        return List.of(pedido1, pedido2, pedido3);
    }
}
