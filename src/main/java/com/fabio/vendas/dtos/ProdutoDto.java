package com.fabio.vendas.dtos;

import com.fabio.vendas.models.Produto;

public class ProdutoDto {

    private String descricao;
    private Double preco;


     public ProdutoDto(Produto produto){
        descricao = produto.getDescricao();
        preco = produto.getPreco();

    }

   public ProdutoDto(){}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
