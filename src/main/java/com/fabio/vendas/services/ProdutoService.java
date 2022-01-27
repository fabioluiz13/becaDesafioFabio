package com.fabio.vendas.services;

import com.fabio.vendas.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    public Produto criar( Produto produto){

        produto.setId(1L);
        return produto;
    }


    public Produto atualizar( Produto produto,  Long id){
        produto.setId(id);
        return  produto;
    }

    public void deletar( Long id){
      //
    }

    public List<Produto> listar(){

        Produto prod1 = new Produto();
        prod1.setId(2L);
        prod1.setDescricao("Arroz");
        prod1.setPreco(15.89);

        Produto prod2 = new Produto();
        prod2.setId(3L);
        prod2.setDescricao("Feijão");
        prod2.setPreco(7.56);

        Produto prod3 = new Produto();
        prod3.setId(4L);
        prod3.setDescricao("Oleo");
        prod3.setPreco(8.99);

        return  List.of(prod1, prod2, prod3);
    }

    public Produto obter( Long id){
        Produto prod1 = new Produto();
        prod1.setId(id);
        prod1.setDescricao("Arroz");
        prod1.setPreco(15.89);

        return prod1;
    }
}

