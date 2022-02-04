package com.fabio.vendas.models;

import com.fabio.vendas.dtos.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido(PedidoDto pedidoDto) {
        this.data = pedidoDto.getData();
        this.cliente = pedidoDto.getCliente();
    }
}
