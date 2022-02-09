package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.ProdutoRequest;
import com.fabio.vendas.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoRequestToProduto {
    public Produto toModel(ProdutoRequest produtoRequest);
}
