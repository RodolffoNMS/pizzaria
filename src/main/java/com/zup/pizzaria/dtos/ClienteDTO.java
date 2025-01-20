package com.zup.pizzaria.dtos;
/*
 * O que esse código faz?
 * Recebe os dados do cliente
 * O cliente vai enviar um JSON com os campos nome, email e telefone.ackage com.zup.pizzaria.dtos;
 * O DTO vai capturar esses dados.
 */
import jakarta.validation.constraints.Email; // Validação para garantir que o campo seja um e-mail válido.
import jakarta.validation.constraints.NotBlank; // Validação para garantir que o campo não seja nulo ou vazio.
import jakarta.validation.constraints.Pattern; // Validação para garantir que o campo siga um padrão específico (regex).
import jakarta.validation.constraints.Size; // Validação para garantir o tamanho mínimo ou máximo do campo.

public class ClienteDTO {
    // Validação para garantir que o nome não seja nulo ou vazio.
    @NotBlank(message = "Por favor, insira um nome.")
    private String nome;

    // Validação para garantir que o e-mail não seja nulo ou vazio e que seja um e-mail válido.
    @NotBlank(message = "Por favor, insira um e-mail.")
    @Email(message = "Por favor, insira um e-mail válido")
    private String email;

    // Validação para garantir que o telefone não seja nulo ou vazio, contenha apenas números e tenha no mínimo 8 dígitos.
    @NotBlank(message = "Por favor, insira um numero de telefone.")
    @Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números.")
    @Size(min = 8, message = "O telefone deve ter ao menos 8 dígitos.")
    private String telefone;

    // Construtor para inicializar os campos do DTO.
    public ClienteDTO(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
