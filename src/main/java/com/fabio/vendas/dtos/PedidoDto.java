package com.fabio.vendas.dtos;

import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.models.Pedido;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class PedidoDto {

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    public PedidoDto(){}

    public PedidoDto(Pedido pedido){
        data = pedido.getData();
        cliente = pedido.getCliente();
     }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
