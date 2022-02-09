package com.fabio.vendas.dtos.responses;

import lombok.Data;

@Data
public class ItemPedidoResponse {

    private Long id;
    private Double preco;
    private int quantidade;
    private ProdutoResponse produto;
}
