package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.responses.ProdutoResponse;
import com.fabio.vendas.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoToProdutoResponse {
    public ProdutoResponse toResponse(Produto produto);
}
