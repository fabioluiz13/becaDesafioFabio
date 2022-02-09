package com.fabio.vendas.dtos.responses;

import lombok.Data;

@Data
public class ProdutoResponse {

    private Long id;
    private String descricao;
    private Double preco;
}
