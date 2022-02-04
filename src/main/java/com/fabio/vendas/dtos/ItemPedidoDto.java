package com.fabio.vendas.dtos;

import com.fabio.vendas.models.ItemPedido;
import com.fabio.vendas.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDto {

    private Double preco;
    private int quantidade;

    @ManyToOne
    private Produto produto;

   public ItemPedidoDto(ItemPedido itemPedido){
       preco = itemPedido.getPreco();
       quantidade = itemPedido.getQuantidade();
       produto = itemPedido.getProduto();
   }
}
