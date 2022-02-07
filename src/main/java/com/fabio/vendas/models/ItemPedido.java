package com.fabio.vendas.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemPedido  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double preco;
    private int quantidade;

    @OneToOne
    private Produto produto;

}
