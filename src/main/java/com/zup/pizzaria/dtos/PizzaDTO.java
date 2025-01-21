package com.zup.pizzaria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PizzaDTO {
    @NotBlank(message = "Por favor, insira um nome.")
    private String nome;

    @NotBlank(message = "Por favor, insira os dados do pedido")
    private String descricao;

    @NotNull(message = "Por favor, algum valor.")
    @Positive(message = "O preço deve ser maior que zero.")
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
