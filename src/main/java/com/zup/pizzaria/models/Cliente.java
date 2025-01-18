package com.zup.pizzaria.models;

import jakarta.persistence.*;

@Entity

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)//Garante que o valor não seja nulo no banco de dados.
    private String nome;
    @Column(nullable = false, unique = true)// Além de não nulo, agora ele deve ser único.
    private String email;
    @Column(nullable = false)
    private String telefone;

    // Construtor padrão (obrigatório para o Hibernate)
    public Cliente() {
    }

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
