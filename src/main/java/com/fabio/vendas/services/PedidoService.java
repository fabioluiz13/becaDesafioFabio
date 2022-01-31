package com.fabio.vendas.services;

import com.fabio.vendas.models.Cliente;
import com.fabio.vendas.models.Pedido;
import com.fabio.vendas.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criar( Pedido pedido) {
        Cliente clienteObtido = clienteService.Obter(pedido.getCliente().getId());
        pedido.setCliente(clienteObtido);
        Pedido pedidoCriado = pedidoRepository.save(pedido);
        return pedidoCriado;
    }

    public Pedido atualizar( Pedido pedido, Long id) {
        Pedido pedidoObtido = this.obter(id);
        pedidoObtido.setCliente(pedido.getCliente());
        pedidoObtido.setData(pedido.getData());
        pedidoRepository.save(pedidoObtido);
        return pedidoObtido;
    }

    public void deletar( Long id) {
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> listar() {
        List<Pedido> listaPedido = pedidoRepository.findAll();
        return listaPedido;
    }

    public Pedido obter(Long id){
        Pedido pedido = pedidoRepository.findById(id).get();
        return  pedido;
    }
}
