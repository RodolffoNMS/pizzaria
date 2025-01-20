package com.zup.pizzaria.models;
/*
* Explicação dos principais pontos:
* Anotações JPA:
* @Entity: Indica que a classe será mapeada para uma tabela no banco de dados.
* @Id: Define o campo como chave primária.
* @GeneratedValue: Configura a estratégia de geração automática do ID.
* @Column: Configura as propriedades da coluna no banco de dados, como nullable e unique.
* Construtor padrão:
* Necessário para o Hibernate criar instâncias da entidade.
* Construtor com parâmetros:
* Facilita a criação de objetos Cliente com os valores necessários.
* Getters e Setters:
* Permitem acessar e modificar os valores dos campos da entidade.
*/

import jakarta.persistence.*;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados.
@Entity

public class Cliente {

    @Id// Define o campo 'id' como chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Gera automaticamente o valor do ID, utilizando a estratégia de auto incremento do banco de dados.
    private Long id;

    //Garante que o valor não seja nulo no banco de dados.
    @Column(nullable = false)
    private String nome;

    // Além de não nulo, agora ele deve ser único.
    @Column(nullable = false, unique = true)
    private String email;

    //Garante que o valor não seja nulo no banco de dados.
    @Column(nullable = false)
    private String telefone;

    // Construtor padrão (obrigatório para o Hibernate).
    // O Hibernate exige um construtor sem argumentos para criar instâncias da entidade.
    public Cliente() {
    }
    // Construtor para inicializar os campos da entidade.
    // Este construtor é usado para criar uma instância de Cliente com os valores fornecidos.
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
