package com.fabio.vendas.model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Long id;
    private LocalDate data;
    private List<ItemPedido> items;
    private Cliente cliente;

    public Pedido(){}

    public Pedido(Long id, LocalDate data, List<ItemPedido> items, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.items = items;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
