package com.fabio.vendas.dtos;

import com.fabio.vendas.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private String descricao;
    private Double preco;

     public ProdutoDto(Produto produto){
        descricao = produto.getDescricao();
        preco = produto.getPreco();
    }
}
