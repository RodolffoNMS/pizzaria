package com.zup.pizzaria.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PedidoDTO {

    @NotBlank(message = "Por favor, insira um nome.")
    private String nomeCliente;

    @NotBlank(message = "Por favor, insira um e-mail.")
    @Email(message = "Por favor, insira um e-mail válido")
    private String emailCliente;

    @NotBlank(message = "Por favor, insira os dados do pedido")
    private String descricaoPedido;

    public PedidoDTO(String nomeCliente, String emailCliente, String descricaoPedido) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.descricaoPedido = descricaoPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }
}
