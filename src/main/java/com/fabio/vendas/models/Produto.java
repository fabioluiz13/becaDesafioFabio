package com.fabio.vendas.models;

import com.fabio.vendas.dtos.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double preco;

    public Produto(ProdutoDto produtoDto){

        this.descricao = produtoDto.getDescricao();
        this.preco = produtoDto.getPreco();
    }
}
