package com.fabio.vendas.services;

import com.fabio.vendas.models.Produto;
import com.fabio.vendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criar( Produto produto){
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo;
    }

    public Produto atualizar( Produto produto,  Long id){
        Produto produtoObtido = this.obter(id);
        produtoObtido.setDescricao(produto.getDescricao());
        produtoObtido.setPreco(produto.getPreco());
        produtoObtido.setPreco(produto.getPreco());
        produtoRepository.save(produtoObtido);
        return  produtoObtido;
    }

    public void deletar( Long id){
      produtoRepository.deleteById(id);
    }

    public List<Produto> listar(){
        List<Produto> listaProduto = produtoRepository.findAll();
        return listaProduto;
    }

    public Produto obter( Long id){
        Produto produto = produtoRepository.findById(id).get();
        if (produto == null){
            throw new RuntimeException("Produto não encontrado");
        }
        return produto;
    }

}

