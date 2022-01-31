package com.fabio.vendas.repositories;

import com.fabio.vendas.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
