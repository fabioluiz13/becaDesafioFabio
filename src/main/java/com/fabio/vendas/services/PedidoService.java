package com.fabio.vendas.services;

import com.fabio.vendas.dtos.PedidoDto;
import com.fabio.vendas.dtos.ProdutoDto;
import com.fabio.vendas.models.Pedido;
import com.fabio.vendas.models.Produto;
import com.fabio.vendas.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoDto criar(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido(pedidoDto);
        return new PedidoDto(pedidoRepository.save(pedido));
    }

    public PedidoDto atualizar( PedidoDto pedidoDto, Long id) {
        return new PedidoDto(pedidoRepository.findById(id)
                .map(pedido -> pedidoRepository.save(new Pedido(pedidoDto)))
                .orElseThrow(ResolutionException::new));
    }


    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public List<PedidoDto> listar() {
        List<PedidoDto> dtos = new ArrayList<>();
        List<Pedido> listaProduto = pedidoRepository.findAll();
        listaProduto.stream().forEach(pedido -> dtos.add(new PedidoDto(pedido)));

        return dtos;
    }

    public PedidoDto obter(Long id) {
        Pedido pedidoRecebido = pedidoRepository.findById(id).get();
        return  new PedidoDto(pedidoRecebido);

    }
}
