package com.fabio.vendas.services;

import com.fabio.vendas.dtos.ProdutoDto;
import com.fabio.vendas.models.Produto;
import com.fabio.vendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDto criar(ProdutoDto produtoDto) {
        Produto produto = new Produto(produtoDto);
        return new ProdutoDto(produtoRepository.save(produto));
    }

    public ProdutoDto atualizar(ProdutoDto produtoDto, Long id) {
        return new ProdutoDto(produtoRepository.findById(id)
                .map(produto -> produtoRepository.save(new Produto(produtoDto)))
                .orElseThrow(ResolutionException::new));
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);

    }

    public List<ProdutoDto> listar() {
        List<ProdutoDto> dtos = new ArrayList<>();
        List<Produto> listaProduto = produtoRepository.findAll();

        listaProduto.stream().forEach(produto -> dtos.add(new ProdutoDto(produto)));

        return dtos;
    }

    public ProdutoDto obter(Long id) {
        Produto produtoRecebido = produtoRepository.findById(id).get();
        return  new ProdutoDto(produtoRecebido);

    }

}

