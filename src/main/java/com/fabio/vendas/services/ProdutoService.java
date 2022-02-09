package com.fabio.vendas.services;

import com.fabio.vendas.dtos.requests.ProdutoRequest;
import com.fabio.vendas.dtos.responses.ProdutoResponse;
import com.fabio.vendas.mappers.MapperProdutoAtualizar;
import com.fabio.vendas.mappers.MapperProdutoRequestToProduto;
import com.fabio.vendas.mappers.MapperProdutoToProdutoResponse;
import com.fabio.vendas.models.Produto;
import com.fabio.vendas.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final MapperProdutoToProdutoResponse produtoResponse;
    private final MapperProdutoRequestToProduto produtoRequestToProduto;
    private final MapperProdutoAtualizar produtoAtualizar;

    public ProdutoResponse criar(ProdutoRequest produtoRequest) {

        Produto produto = produtoRequestToProduto.toModel(produtoRequest);
        return produtoResponse.toResponse(produtoRepository.save(produto));
    }

    public ProdutoResponse atualizar(ProdutoRequest produtoRequest, Long id) {
        Produto produto =produtoRepository.findById(id).get();
        produtoAtualizar.atualizar(produtoRequest, produto);
        return produtoResponse.toResponse(produtoRepository.save(produto));
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);

    }

    public List<ProdutoResponse> listar() {
        List<Produto> listaProdutos = produtoRepository.findAll();
       return listaProdutos
               .stream()
               .map(produtoResponse::toResponse)
               .collect(Collectors.toList());
    }

    public ProdutoResponse obter(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        return  produtoResponse.toResponse(produto);
    }
}

