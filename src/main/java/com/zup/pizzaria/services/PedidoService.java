package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service //indica ao spring que essa é uma classe de service

public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    // Construtor para injeção de dependências
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    // Método para criar um pedido
    public PedidoDTO criarPedido(Pedido pedido) {
        // Busca o cliente pelo ID associado ao pedido
        Cliente cliente = clienteRepository
                .findById(pedido.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        // Salva o pedido no banco de dados
        pedidoRepository.save(pedido);
        // Retorna um DTO com as informações do cliente e do pedido
        return new PedidoDTO(cliente.getNome(), cliente.getEmail(), pedido.getDescricao());
    }
}
