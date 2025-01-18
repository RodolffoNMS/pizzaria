package com.zup.pizzaria.dtos;
/*
* O que esse código faz?
* Recebe os dados do cliente
* O cliente vai enviar um JSON com os campos nome, email e telefone.ackage com.zup.pizzaria.dtos;
* O DTO vai capturar esses dados.
*/


public class ClienteDTO {
    private String nome;
    private String email;
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
