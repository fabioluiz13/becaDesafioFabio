package com.fabio.vendas.repositories;

import com.fabio.vendas.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
