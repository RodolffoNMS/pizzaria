package com.zup.pizzaria.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {
    @NotBlank(message = "Por favor, insira um nome.")
    private String nome;

    @NotBlank(message = "Por favor, insira um e-mail.")
    @Email(message = "Por favor, insira um e-mail válido")
    private String email;

    @NotBlank(message = "Por favor, insira um numero de telefone.")
    @Pattern(regexp = "\\d{2}\\d{8,9}", message = "O telefone deve conter o código de área e entre 8 a 9 dígitos.")
    @Size(min = 8, message = "O telefone deve ter ao menos 8 dígitos.")
    private String telefone;

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
