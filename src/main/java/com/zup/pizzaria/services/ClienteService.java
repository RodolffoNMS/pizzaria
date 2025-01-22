package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveClient(Cliente cliente) {
        //Verifica antes de mandar para o banco.
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("O e-mail informado já está em uso.");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listAllClients()    {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente updatedCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(cliente.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}