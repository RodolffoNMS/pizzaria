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
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // Indica que esta classe é um controlador REST, responsável por lidar com requisições HTTP.
@RequestMapping("/clientes") // Essa é a definção do endpoint. A base para todas as requisições deste controlador.
public class ClienteController {

    @Autowired //Injeta automaticamente a dependência do ClienteService, que será usado para salvar os clientes.
    private ClienteService clienteService;

    @PostMapping //Mapeia as requisições HTTP POST para esse método:
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        // @Valid: Garante que as validações definidas no ClienteDTO sejam aplicadas.
        // @RequestBody: Converte o corpo da requisição JSON para um objeto ClienteDTO.

        // Converte o DTO (objeto de transferência de dados) para a entidade Cliente.
        Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getTelefone());
        // Salva o cliente no banco de dados usando o serviço.
        Cliente clienteSalvo = clienteService.salvarCliente(cliente);
        // Retorna uma resposta HTTP com status 201 (Created) e o cliente salvo no corpo da resposta.
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // Trata exceções de validação de argumentos.
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Cria um mapa para armazenar os erros de validação.
        Map<String, String> errors = new HashMap<>();
        // Itera sobre os erros de validação e adiciona o campo e a mensagem de erro ao mapa.
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        // Retorna uma resposta HTTP com status 400 (Bad Request) e o mapa de erros no corpo da resposta.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
