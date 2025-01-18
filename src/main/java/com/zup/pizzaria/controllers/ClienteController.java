/*
* Recebe os dados do cliente:
* O cliente envia um JSON com os dados (nome, email, telefone).
* O Spring converte automaticamente o JSON para o objeto ClienteDTO.
* Converte o DTO para a entidade Cliente:
* Como o banco de dados trabalha com a entidade Cliente, precisamos converter o ClienteDTO para Cliente.
* Salva o cliente no banco de dados:
* O metodo clienteService.salvarCliente(cliente) salva o cliente no banco.
* Retorna uma resposta:
* Se tudo der certo, o servidor retorna o status 201 Created e a mensagem "Cliente cadastrado com sucesso!".*/

package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> cadastrarCliente (@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getTelefone());
        clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso!");
    }
}
