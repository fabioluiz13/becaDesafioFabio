package com.fabio.vendas.model;

public class ItemPedido {

    private Long id;
    private Double preco;
    private int quantidade;
    private Produto produto;

    public ItemPedido(){}

    public ItemPedido(Long id, Double preco, int quantidade, Produto produto) {
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
