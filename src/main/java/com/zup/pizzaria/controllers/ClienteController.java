package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getTelefone());
        Cliente clienteSalvo = clienteService.saveClient(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    /*
     * 1. @ExceptionHandler(DataIntegrityViolationException.class)
     * O que faz:
     * Esta anotação indica que o metodo abaixo será responsável por tratar exceções do tipo
     * DataIntegrityViolationException.
     * Sempre que essa exceção for lançada em qualquer parte do código dentro do mesmo Controller,
     * este metodo será chamado automaticamente.

     * Por que usar:
     * Isso permite centralizar o tratamento de erros específicos, como violações de integridade de dados
     * (por exemplo, tentativa de inserir um valor duplicado em uma coluna com restrição unique no banco de dados).

     * 2. public ResponseEntity<...{
     * O que faz:
     * Define o metodo que será executado quando a exceção DataIntegrityViolationException for capturada.
     * O metodo retorna um objeto do tipo ResponseEntity<Map<String, String>>, que é uma resposta HTTP
     * contendo um corpo no formato de um mapa (Map) com chave e valor do tipo String.

     * Parâmetro ex:
     * O parâmetro ex contém a exceção capturada, permitindo que você acesse informações sobre o erro ocorrido
     * (como a mensagem ou a causa).

     * 3. Map<String, String> error = new HashMap<>();
     * O que faz:
     * Cria um novo mapa (HashMap) para armazenar as informações de erro que serão enviadas na resposta HTTP.
     * O mapa é usado para estruturar a mensagem de erro no formato chave-valor, onde a chave é "error" e o valor
     * é a mensagem de erro.

     * 4. error.put("error", "O e-mail informado já está em uso. Por favor, insira um e-mail diferente.");
     * O que faz:
     * Adiciona uma entrada ao mapa error com a chave "error" e o
     * valor "O e-mail informado já está em uso. Por favor, insira um e-mail diferente.".
     * Essa mensagem será enviada ao cliente como parte da resposta HTTP, informando o motivo do erro.

     * 5. return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
     * O que faz:
     * Cria e retorna uma resposta HTTP com:
     * Status HTTP: HttpStatus.BAD_REQUEST (código 400), que indica que houve um erro na solicitação do cliente.

     * Corpo da resposta: O mapa error, que contém a mensagem de erro.
     * Por que usar:
     * O ResponseEntity é uma classe do Spring que permite personalizar completamente a resposta HTTP,
     * incluindo o status, cabeçalhos e corpo.
     * Aqui, o status BAD_REQUEST é usado porque o cliente enviou dados inválidos (um e-mail duplicado, no caso).

     * Resumo do Fluxo:
     * Quando uma exceção DataIntegrityViolationException ocorre, o Spring chama automaticamente este metodo.
     *O metodo cria um mapa contendo uma mensagem de erro amigável.
     *O metodo retorna uma resposta HTTP com o status 400 (BAD_REQUEST) e o corpo contendo a mensagem de erro.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public  ResponseEntity<Map<String, String>> erroEmailDuplicado(DataIntegrityViolationException ex){
        Map<String, String> erro = new HashMap<>();
        erro.put("Erro!", "O e-mail já está cadastrado em nossa base de dados.Por favor, use um e-mail diferente.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){
        List<Cliente> cliente = clienteService.listAllClients();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarCliente(@PathVariable Long id) {
        return clienteService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updatedCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente updatedCliente = clienteService.updatedCliente(id, clienteDTO);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
            System.out.println("Erro de validação no campo: " + error.getField() + " - " + error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
