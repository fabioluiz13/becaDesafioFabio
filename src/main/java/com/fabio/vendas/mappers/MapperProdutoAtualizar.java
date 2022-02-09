package com.fabio.vendas.mappers;

import com.fabio.vendas.dtos.requests.ProdutoRequest;
import com.fabio.vendas.models.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperProdutoAtualizar {
    public void atualizar(ProdutoRequest produtoRequest, @MappingTarget Produto produto);
}
