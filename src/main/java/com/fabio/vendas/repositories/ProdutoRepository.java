package com.fabio.vendas.repositories;

import com.fabio.vendas.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
