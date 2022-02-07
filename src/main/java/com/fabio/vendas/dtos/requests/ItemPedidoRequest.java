package com.fabio.vendas.dtos.requests;

import lombok.Data;

@Data
public class ItemPedidoRequest {


    private Double preco;
    private int quantidade;
    private ProdutoRequest produto;
}
