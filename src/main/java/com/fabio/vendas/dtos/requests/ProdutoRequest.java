package com.fabio.vendas.dtos.requests;

import lombok.Data;

@Data
public class ProdutoRequest {

    private Long id;
    private String descricao;
    private Double preco;
}
