package com.fabio.vendas.dtos;

import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.models.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    private LocalDate data;

    @ManyToOne
    private Cliente cliente;

    public PedidoDto(Pedido pedido){
        data = pedido.getData();
        cliente = pedido.getCliente();
     }
}
