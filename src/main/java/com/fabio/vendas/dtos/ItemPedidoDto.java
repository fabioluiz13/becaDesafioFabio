package com.fabio.vendas.dtos;

import com.fabio.vendas.models.ItemPedido;
import com.fabio.vendas.models.Produto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemPedidoDto {


    private Double preco;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemPedidoDto() {
    }

   public ItemPedidoDto(ItemPedido itemPedido){
       preco = itemPedido.getPreco();
       quantidade = itemPedido.getQuantidade();
       produto = itemPedido.getProduto();
   }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
