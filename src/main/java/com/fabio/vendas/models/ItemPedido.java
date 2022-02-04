package com.fabio.vendas.models;

import com.fabio.vendas.dtos.ItemPedidoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemPedido  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double preco;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemPedido(ItemPedidoDto itemPedidoDto){
      this.preco = itemPedidoDto.getPreco();
      this.quantidade = itemPedidoDto.getQuantidade();
      this.produto = itemPedidoDto.getProduto();
    }
}
